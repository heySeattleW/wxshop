$(function () {

    $("#jqGrid").Grid({
        url: '../goods/list',
        colModel: [
            {label: 'id', name: 'id', index: 'id', key: true, hidden: true},
            {label: '商品类型', name: 'categoryName', index: 'category_id', width: 80},
            {label: '名称', name: 'name', index: 'name', width: 160},
            {label: '品牌', name: 'brandName', index: 'brand_id', width: 120},
            {
                label: '上架', name: 'isOnSale', index: 'is_on_sale', width: 50,
                formatter: function (value) {
                    return transIsNot(value);
                }
            },
            {
                label: '录入日期', name: 'addTime', index: 'add_time', width: 80, formatter: function (value) {
                    return transDate(value, 'yyyy-MM-dd');
                }
            },
            {label: '属性类别', name: 'attributeCategoryName', index: 'attribute_category', width: 80},
            {label: '零售价格', name: 'retailPrice', index: 'retail_price', width: 80},
            {label: '商品库存', name: 'goodsNumber', index: 'goods_number', width: 80},
            {label: '销售量', name: 'sellVolume', index: 'sell_volume', width: 80},
            {label: '市场价', name: 'marketPrice', index: 'market_price', width: 80},
            {
                label: '热销', name: 'isHot', index: 'is_hot', width: 80, formatter: function (value) {
                    return transIsNot(value);
                }
            }]
    });
   
    $('#goodsDesc').editable({
        inlineMode: false,
        alwaysBlank: true,
        height: '500px', //高度
        minHeight: '200px',
        language: "zh_cn",
        spellcheck: false,
        plainPaste: true,
        enableScript: false,
        imageButtons: ["floatImageLeft", "floatImageNone", "floatImageRight", "linkImage", "replaceImage", "removeImage"],
        allowedImageTypes: ["jpeg", "jpg", "png", "gif"],
        imageUploadURL: '../sys/oss/upload',
        imageUploadParams: {id: "edit"},
        imagesLoadURL: '../sys/oss/queryAll'
    })
});

var ztree;

var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url: "nourl"
        }
    }
};
var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        showGoods: false,
        title: null,
        uploadList: [],
        imgName: '',
        visible: false,
        goods: {
            primaryPicUrl: '',
            listPicUrl: '',
            categoryId: '',
            isOnSale: 1,
            isNew: 1,
            isAppExclusive: 0,
            isLimited: 0,
            isHot: 0,
            categoryName: '',
            goodsSpecificationList:[],
        	deleteGoodsSpecificationList:[],
        	goodsAttributeList:[]
        },
        ruleValidate: {
            name: [
                {required: true, message: '名称不能为空', trigger: 'blur'}
            ]
        },
        q: {
            name: ''
        },
        goodsSpecification:{},
        specifications:[],
        brands: [],//品牌
        macros: [],//商品单位
        attributeCategories: [] ,//属性类别
        
    },
    methods: {
        query: function () {
            vm.reload();
        },
        refreshSpecificationGrid: function(){
        	$("#specificationGrid").Grid({
			        datatype : "local",
			        colModel: [
			             {label: 'id', name: 'id', index: 'id', key: true, hidden: true},  
		                 {label: '规格', name: 'specificationName', index: 'specification_id', width: 180},
			             {label: '规格说明', name: 'value', index: 'value', width: 380},
			              {
			                label: '规格图片', name: 'picUrl', index: 'pic_url', width: 200, formatter: function (value) {
			                    return transImg(value);
			                }
			             }]
	        });
	        if(vm.goods.goodsSpecificationList==null)
	        	vm.goods.goodsSpecificationList=[];
	        $("#specificationGrid").jqGrid('clearGridData');     
	        for(var i=0;i< vm.goods.goodsSpecificationList.length;i++){
	        	 $("#specificationGrid").jqGrid('addRowData', i+1, vm.goods.goodsSpecificationList[i]);  
	       	}
        },
         getSpecification: function () {
            Ajax.request({
                url: "../specification/queryAll",
                async: true,
                successCallback: function (r) {
                    vm.specifications = r.list;
                }
            });
        },
        addgoodsSpecification: function(){
        	vm.goodsSpecification={
        		 specificationId:'',
        		 specificationName:'',
        		 value:'',
        		 picUrl:'',
        		 goodsSpecificationList:[],
        		 deleteGoodsSpecificationList:[],
        		 goodsAttributeList:[]
        	};
        	vm.getSpecification();
        	vm.refreshSpecificationGrid();
        	openWindow({
                title: "增加规格",
                area: ['800px', '350px'],
                content: jQuery("#sendDiv")
            })
        },
        delgoodsSpecification: function (event) {
            var ids = getSelectedRows("#specificationGrid");
            if (ids == null) {
                return;
            }
            confirm('确定要删除选中的记录？', function () {
                  ids.sort();
            	for(var index=ids.length; index>0;index--){
            		
            		if(vm.goods.goodsSpecificationList[ids[index-1]-1].id!=null){
            		
            			vm.goods.deleteGoodsSpecificationList.push(vm.goods.goodsSpecificationList[ids[index-1]-1]);
            		}
            		
            		vm.goods.goodsSpecificationList.splice(ids[index-1]-1,1);
	            }
	             alert('提交成功', function (index) {
                            vm.refreshSpecificationGrid();
                        });
	           
            });
          
       },
       updategoodsSpecification: function (event) {
            var id = getSelectedRow("#specificationGrid");
            if (id == null) {
                return;
            }
            vm.goodsSpecification=vm.goods.goodsSpecificationList[id-1];
			vm.getSpecification();
			openWindow({
                title: "增加规格",
                area: ['800px', '350px'],
                content: jQuery("#sendDiv")
            })
           
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.uploadList = [];
            vm.goods = {
                primaryPicUrl: '',
                listPicUrl: '',
                categoryId: '',
                isOnSale: 1,
                isNew: 1,
                isAppExclusive: 0,
                isLimited: 0,
                isHot: 0,
                categoryName: '',
	            goodsAttributeList:[],
	            selectAttributeList:[]
            };
              Ajax.request({
                url: "../goods/newgood",
                async: true,
                successCallback: function (r) {
                    vm.goods = r.goods;
                }
            });
            vm.refreshSpecificationGrid();
            $('#goodsDesc').editable('setHTML', '');
            vm.getCategory();
            vm.brands = [];
            vm.macros = [];
            vm.attributeCategories = [];
            // vm.attribute = [];
            vm.getBrands();
            vm.getMacro();
            vm.getAttributeCategories();
            vm.getGoodsGallery(id);
        },
        update: function (event) {
            var id = getSelectedRow("#jqGrid");
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";
            vm.uploadList = [];
            vm.getInfo(id);
            vm.getBrands();
            vm.getMacro();
            vm.getAttributeCategories();
            vm.getGoodsGallery(id);
        },
       
        
        /**
         * 获取品牌
         */
        getBrands: function () {
            Ajax.request({
                url: "../brand/queryAll",
                async: true,
                successCallback: function (r) {
                    vm.brands = r.list;
                }
            });
        },
        /**
         * 获取单位
         */
        getMacro: function () {
            Ajax.request({
                url: "../sys/macro/queryMacrosByValue?value=goodsUnit",
                async: true,
                successCallback: function (r) {
                    vm.macros = r.list;
                }
            });
        },
        /**
        *获取规格
        */
        showSpecificationGrid: function(id) {
        	Ajax.request({
	                       url: '../goodsspecification/queryAllbyGoods/'+id,
	                        async: true,
	                        successCallback: function (r) {
	                            vm.goods.goodsSpecificationList = r.list;
	                            vm.goods.deleteGoodsSpecificationList=[];
	                            vm.refreshSpecificationGrid();
	                        }
	         });
           
        },
        changeAttributeCategory:function(opt){//修改商品参数
       		 let categoryId = opt.value;
       		
	        	Ajax.request({
		                        url: "../goodsattribute/queryAll?goodsId=" + vm.goods.id+"&attributeCategoryId=" + categoryId,
		                        async: true,
		                        successCallback: function (r) {
		                            vm.goods.goodsAttributeList = r.list;
		                        }
		               });
		    
        },
        loadAttributeCategory:function(goodsId){//加载商品参数
        	Ajax.request({
	                        url: "../goodsattribute/queryAll?goodsId=" + goodsId,
	                        async: true,
	                        successCallback: function (r) {
	                            vm.goods.goodsAttributeList = r.list;
	                        }
	               });
        },
        getGoodsGallery: function (id) {//获取商品顶部轮播图
            Ajax.request({
                url: "../goodsgallery/queryAll?goodsId=" + id,
                async: true,
                successCallback: function (r) {
                    vm.uploadList = r.list;
                }
            });
        },
        getAttributeCategories: function () {
            Ajax.request({
                url: "../attributecategory/queryAll",
                async: true,
                successCallback: function (r) {
                    vm.attributeCategories = r.list;
                }
            });
        },
        saveOrUpdateSpecification(){
        	if(vm.goodsSpecification.id ==null){
        		vm.goods.goodsSpecificationList.push(vm.goodsSpecification);
        	}else{
        		vm.goods.goodsSpecificationList[vm.goodsSpecification.index]=vm.goodsSpecification;
        	}
         	let obj = vm.specifications.find((item)=>{
                                return item.id === vm.goodsSpecification.specificationId;
                });
                vm.goodsSpecification.specificationName=obj.name;
        	alert('提交成功', function (index) {
                            vm.refreshSpecificationGrid();
                             layer.closeAll();
                        });
        	
        },
        saveOrUpdate: function (event) {
            var url = vm.goods.id == null ? "../goods/save" : "../goods/update";
            vm.goods.goodsDesc = $('#goodsDesc').editable('getHTML');
            vm.goods.goodsImgList = vm.uploadList;
            Ajax.request({
                type: "POST",
                url: url,
                contentType: "application/json",
                params: JSON.stringify(vm.goods),
                successCallback: function (r) {
                    alert('操作成功', function (index) {
                        vm.reload();
                        layer.closeAll();
                    });
                }
            });
        },
        enSale: function () {
            var id = getSelectedRow("#jqGrid");
            if (id == null) {
                return;
            }
            confirm('确定要上架选中的商品？', function () {
                Ajax.request({
                    type: "POST",
                    url: "../goods/enSale",
                    params: JSON.stringify(id),
                    contentType: "application/json",
                    type: 'POST',
                    successCallback: function () {
                        alert('提交成功', function (index) {
                            vm.reload();
                        });
                    }
                });
            });
        },
        openSpe: function () {
            var id = getSelectedRow("#jqGrid");
            if (id == null) {
                return;
            }
            openWindow({
                type: 2,
                title: '商品规格',
                content: '../shop/goodsspecification.html?goodsId=' + id
            })
        },
        openPro: function () {
            var id = getSelectedRow("#jqGrid");
            if (id == null) {
                return;
            }
            openWindow({
                type: 2,
                title: '产品设置',
                content: '../shop/product.html?goodsId=' + id
            });
        },
        unSale: function () {
            var id = getSelectedRow("#jqGrid");
            if (id == null) {
                return;
            }
            confirm('确定要下架选中的商品？', function () {

                Ajax.request({
                    type: "POST",
                    url: "../goods/unSale",
                    contentType: "application/json",
                    params: JSON.stringify(id),
                    successCallback: function (r) {
                        alert('操作成功', function (index) {
                            vm.reload();;
                        });
                    }
                });

            });
        },
        del: function (event) {
            var ids = getSelectedRows("#jqGrid");
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                Ajax.request({
                    type: "POST",
                    url: "../goods/delete",
                    contentType: "application/json",
                    params: JSON.stringify(ids),
                    successCallback: function (r) {
                        alert('操作成功', function (index) {
                            vm.reload();;
                        });
                    }
                });

            });
        },
        getInfo: function (id) {
            Ajax.request({
                url: "../goods/info/" + id,
                async: true,
                successCallback: function (r) {
                    vm.goods = r.goods;
                    $('#goodsDesc').editable('setHTML', vm.goods.goodsDesc);
                    vm.getCategory();
                     vm.showSpecificationGrid(id);
            		
                }
            });
         
           
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'name': vm.q.name},
                page: page
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
        },
        reloadSpecificationGrid: function (event) {
           
          
        },
        getCategory: function () {
            //加载分类树
            Ajax.request({
                url: "../category/queryAll",
                async: true,
                successCallback: function (r) {
                    ztree = $.fn.zTree.init($("#categoryTree"), setting, r.list);
                    var node = ztree.getNodeByParam("id", vm.goods.categoryId);
                    if (node) {
                        ztree.selectNode(node);
                        vm.goods.categoryName = node.name;
                    } else {
                        node = ztree.getNodeByParam("id", 0);
                        ztree.selectNode(node);
                        vm.goods.categoryName = node.name;
                    }
                }
            });
        },
        categoryTree: function () {
            openWindow({
                title: "选择类型",
                area: ['300px', '450px'],
                content: jQuery("#categoryLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    vm.goods.categoryId = node[0].id;
                    vm.goods.categoryName = node[0].name;

                    layer.close(index);
                }
            });
        },
        handleView(name) {
            this.imgName = name;
            this.visible = true;
        },
        handleRemove(file) {
            // 从 upload 实例删除数据
            const fileList = this.uploadList;
            this.uploadList.splice(fileList.indexOf(file), 1);
        },
        handleSuccess(res, file) {
            // 因为上传过程为实例，这里模拟添加 url
            file.imgUrl = res.url;
            file.name = res.url;
            vm.uploadList.add(file);
        },
        handleSuccessSpecification(res, file) {
            // 因为上传过程为实例，这里模拟添加 url
            vm.goodsSpecification.picUrl=res.url;
        },
        handleBeforeUpload() {
            const check = this.uploadList.length < 5;
            if (!check) {
                this.$Notice.warning({
                    title: '最多只能上传 5 张图片。'
                });
            }
            return check;
        },
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleSubmitSpecification: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdateSpecification()
            });
        },
        handleFormatError: function (file) {
            this.$Notice.warning({
                title: '文件格式不正确',
                desc: '文件 ' + file.name + ' 格式不正确，请上传 jpg 或 png 格式的图片。'
            });
        },
        handleMaxSize: function (file) {
            this.$Notice.warning({
                title: '超出文件大小限制',
                desc: '文件 ' + file.name + ' 太大，不能超过 2M。'
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        },
        handleSuccessPicUrl: function (res, file) {
            vm.goods.primaryPicUrl = file.response.url;
        },
        handleSuccessListPicUrl: function (res, file) {
            vm.goods.listPicUrl = file.response.url;
        },
        eyeImagePicUrl: function () {
            var url = vm.goods.primaryPicUrl;
            eyeImage(url);
        },
        eyeImageSpecification: function() {
         	var url = vm.goodsSpecification.picUrl;
            eyeImage(url);
        },
        eyeImageListPicUrl: function () {
            var url = vm.goods.listPicUrl;
            eyeImage(url);
        },
        eyeImage: function (e) {
            eyeImage($(e.target).attr('src'));
        }
    },
    mounted() {
        this.uploadList = this.$refs.upload.fileList;
    }
});