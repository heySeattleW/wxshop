$(function () {
    $("#jqGrid").Grid({
        url: '../activity/list',
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true},
			{label: '名称', name: 'name', index: 'name', width: 80},
			{label: '开始时间', name: 'startTime', index: 'start_time', width: 80
			,  formatter: function (value) {return transDate(value,'yyyy-MM-dd hhmm');}},
			{label: '结束时间', name: 'endTime', index: 'end_time', width: 80
			,  formatter: function (value) {return transDate(value,'yyyy-MM-dd hhmm');}}]
    });
    vm.loadcouponList();
    vm.loadgoodsList();
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		activity: {},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		q: {
		    name: ''
		},
		couponList:[],
		goodsList:[],
		showGoods:false,
		lastsel:null,
	},
	methods: {
	    loadcouponList: function(){
	    
	    	  Ajax.request({
				    url: "../coupon/queryAll",
                    async: true,
                	successCallback: function (r) {
                   		vm.couponList=r.list;
                   		
					}
				});
	    },
	    loadgoodsList: function(){
	    
	    	  Ajax.request({
				    url: "../activitygoods/selectAllActivityGoods",
                    async: true,
                	successCallback: function (r) {
                   		vm.goodsList=r.list;
                   		
					}
				});
	    },
	    refreshGoodsGrid: function(){
        	$("#goodsGrid").Grid({
			        datatype : "local",
			        colModel: [
			             {label: 'id', name: 'id', index: 'id', key: true, hidden: true},
			             {label: 'productId', name: 'productId', index: 'productId',  hidden: true},  
		                 {label: '商品', name: 'goodsName', index: 'goodsName', width: 180},
			             {label: '规格', name: 'goodsSpecificationName', index: 'goodsSpecificationName', width: 180},
			             {label: '原价', name: 'price', index: 'price', width: 180},
			              {
			                label: '商品图片', name: 'picUrl', index: 'pic_url', width: 200, formatter: function (value) {
			                    return transImg(value);
			                }
			             }]
	        });
	       
	        $("#goodsGrid").jqGrid('clearGridData');     
	        for(var i=0;i< vm.goodsList.length;i++){
	        	 $("#goodsGrid").jqGrid('addRowData', i+1, vm.goodsList[i]);  
	       	}
        },
	    refreshActivityGoodsGrid: function(){
        	$("#activityGoodsGrid").Grid({
			        datatype : "local",
			        colModel: [
			             {label: 'id', name: 'id', index: 'id', key: true, hidden: true},
			             {label: 'productId', name: 'productId', index: 'productId',  hidden: true},  
		                 {label: '商品', name: 'goodsName', index: 'goodsName', width: 100},
			             {label: '规格', name: 'goodsSpecificationName', index: 'goodsSpecificationName', width: 180},
			             {label: '原价', name: 'price', index: 'price', width: 80},
			             {label: '活动价', name: 'activityPrice', index: 'activityPrice',editable: true, width: 80},
			              {
			                label: '商品图片', name: 'picUrl', index: 'picUrl', width: 150, formatter: function (value) {
			                    return transImg(value);
			                }
			             }],
			         onSelectRow : function(id) {
					          if (id ) {
					          	if(vm.lastsel){
					          	  $('#activityGoodsGrid').jqGrid('saveRow', vm.lastsel, false, 'clientArray');
					            }
					            $('#activityGoodsGrid').jqGrid('editRow', id, true);
					            vm.lastsel = id;
					          }
       				 },     
	        });
	        if(vm.activity.activityGoodsList==null)
	        	vm.activity.activityGoodsList=[];
	        $("#activityGoodsGrid").jqGrid('clearGridData');     
	        for(var i=0;i< vm.activity.activityGoodsList.length;i++){
	       		
	        	 $("#activityGoodsGrid").jqGrid('addRowData', i+1, vm.activity.activityGoodsList[i]);  
	       		 
	       	}
        },
        addActivityGood: function(){
        	
        	
        	vm.activity.selectCouponList=[];
        	
        	vm.refreshGoodsGrid();
        	vm.showGoods=true;
        	openWindow({
                title: "添加商品",
                area: ['860px', '600px'],
                content: jQuery("#goodsDiv")
            })
        },
        deleteActivityGoods:function(){
        
        	var ids = getSelectedRows("#activityGoodsGrid");
            if (ids == null) {
                return;
            }
            confirm('确定要删除选中的记录？', function () {
                ids.sort();
            	for(var index=ids.length; index>0;index--){
            		
            		if(vm.activity.activityGoodsList[ids[index-1]-1].id!=null){
            		
            			vm.activity.delActivityGoodsList.push(vm.activity.activityGoodsList[ids[index-1]-1]);
            		}
            		
            		vm.activity.activityGoodsList.splice(ids[index-1]-1,1);
	            }
	             alert('提交成功', function (index) {
                            vm.refreshActivityGoodsGrid();
                        });
                        
	           
            });
            
        	
        },
        commitActivityGoodsList:function(){
	        var ids = getSelectedRows("#goodsGrid");
	            if (ids == null) {
	                return;
	        }
        	for(var index=ids.length; index>0;index--){
        		 var product=vm.goodsList[ids[index-1]-1];
        		 var find=false;
        		 for(var i=0;i< vm.activity.activityGoodsList.length;i++){
	        		if(vm.activity.activityGoodsList[i].productId==product.productId)
	        		{
	        		 find=true;
	        		 break;
	        		}
	       		  }
	       		  if(find==false){
	        	 	vm.activity.activityGoodsList.push(product);
	        	  }
	       	}
	       	 alert('提交成功', function (index) {
                            vm.refreshActivityGoodsGrid();
                             layer.closeAll();
                        });
        },
       
        
        closeSelectGood: function(){
        	vm.showGoods=false;
        },
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.activity = {};
			vm.activity.selectCouponList=[];
			vm.activity.delActivityGoodsList=[];
			vm.activity.activityGoodsList=[];
			vm.refreshActivityGoodsGrid();
			
		},
		update: function (event) {
            let id = getSelectedRow("#jqGrid");
			if (id == null) {
				return;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(id)
          
		},
		saveOrUpdate: function (event) {
            let url = vm.activity.id == null ? "../activity/save" : "../activity/update";
            let activityGoodsList=[];
             $('#activityGoodsGrid').jqGrid('saveRow', vm.lastsel, false, 'clientArray');
					           
            for(var i=0;i< vm.activity.activityGoodsList.length;i++){
	       		
	        	 activityGoodsList[i]=$("#activityGoodsGrid").jqGrid('getRowData', i+1);  
	       		 activityGoodsList[i].picUrl=null;
	       	}
	       	vm.activity.activityGoodsList=activityGoodsList;
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.activity),
                type: "POST",
			    contentType: "application/json",
                successCallback: function (r) {
                    alert('操作成功', function (index) {
                        vm.reload();
                    });
                }
			});
		},
		del: function (event) {
            let ids = getSelectedRows("#jqGrid");
			if (ids == null){
				return;
			}

			confirm('确定要删除选中的记录？', function () {
                Ajax.request({
				    url: "../activity/delete",
                    params: JSON.stringify(ids),
                    type: "POST",
				    contentType: "application/json",
                    successCallback: function () {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
					}
				});
			});
		},
		getInfo: function(id){
            Ajax.request({
                url: "../activity/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.activity = r.activity;
                    vm.activity.delActivityGoodsList=[];
                    vm.refreshActivityGoodsGrid();
                }
            });
		},
		reload: function (event) {
			vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {'name': vm.q.name},
                page: page
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
		},
        reloadSearch: function() {
            vm.q = {
                name: ''
            }
            vm.reload();
        },
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        }
	}
});