$(function () {
    $("#jqGrid").Grid({
        url: '../aftersales/list',
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true},
			{label: '购买人', name: 'userName', index: 'user_name', width: 80},
			{label: '订单编号', name: 'orderSn', index: 'order_sn', width: 80},
			{label: '商品名称', name: 'goodsName', index: 'goods_name', width: 80},
			{label: '商品规格', name: 'goodsSpecifitionNames', index: 'goodsSpecifitionNames', width: 80},
			{label: '产品序列号', name: 'productSn', index: 'product_sn', width: 80},
			{label: '购买时间', name: 'buyTime', index: 'buy_time', width: 80,
			 formatter: function (value) {
                    return transDate(value);
                }},
			{label: '保修时间', name: 'repairEndTime', index: 'repair_end_time', width: 80,
			 formatter: function (value) {
                    return transDate(value);
                }}]
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        repairShow: false,
        title: null,
        repair:{},
		nideShopAftersales: {},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		q: {
		    name: ''
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.nideShopAftersales = {};
			vm.refreshRepairGrid();
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
            let url = vm.nideShopAftersales.id == null ? "../aftersales/save" : "../aftersales/update";
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.nideShopAftersales),
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
				    url: "../aftersales/delete",
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
                url: "../aftersales/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.nideShopAftersales = r.aftersales;
                    vm.refreshRepairGrid();
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
        },
        
        refreshRepairGrid: function(){
        	$("#repairGrid").Grid({
			        datatype : "local",
			        colModel: [
			             {label: 'id', name: 'id', index: 'id', key: true, hidden: true},  
		                 {label: '维修时间', name: 'repairTime', index: 'repairTime', width: 180,
		                  formatter: function (value) {
                    return transDate(value);
                }},
			             {label: '维修内容', name: 'info', index: 'info', width: 580}]
	        });
	        if(vm.nideShopAftersales.repairList==null)
	        	vm.nideShopAftersales.repairList=[];
	        $("#repairGrid").jqGrid('clearGridData');     
	        for(var i=0;i< vm.nideShopAftersales.repairList.length;i++){
	        	 $("#repairGrid").jqGrid('addRowData', i+1,  vm.nideShopAftersales.repairList[i]);  
	       		 vm.nideShopAftersales.repairList[i].index=i;
	       	}
        },
        addRepair: function(){
        	vm.repair={  
        				
        	};
        	
        	vm.refreshRepairGrid();
        	openWindow({
                title: "维修记录",
                area: ['800px', '350px'],
                content: jQuery("#repairDiv")
            })
        },
        delRepair: function (event) {
            var ids = getSelectedRows("#repairGrid");
            if (ids == null) {
                return;
            }
            confirm('确定要删除选中的记录？', function () {
                
            	for(var index=ids.length; index>0;index--){
            		
            		if(vm.nideShopAftersales.repairList[ids[index-1]-1].id!=null){
            		
            			vm.nideShopAftersales.deleteRepairList.push(vm.nideShopAftersales.repairList[ids[index-1]-1]);
            		}
            		
            		vm.nideShopAftersales.repairList.splice(ids[index-1]-1,1);
	            }
	             alert('提交成功', function (index) {
                            vm.refreshRepairGrid();
                        });
	           
            });
          
       },
       updateRepairn: function (event) {
            var id = getSelectedRow("#repairGrid");
            if (id == null) {
                return;
            }
            vm.repair=vm.nideShopAftersales.repairList[id-1];
			openWindow({
                title: "维修记录",
                area: ['800px', '350px'],
                content: jQuery("#repairDiv")
            })
           
        },
        saveOrUpdateRepair:  function(){
        	if(vm.repair.id == null){
        		vm.repair.id=null;
        		
        		vm.nideShopAftersales.repairList.push(vm.repair);
        	}else{
        		vm.nideShopAftersales.repairList[vm.repair.index]=vm.repair;
        	}
        	alert('提交成功', function (index) {
                            vm.refreshRepairGrid();
                            layer.closeAll();
                        });
        },
         handleSubmitRepair: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdateRepair()
            });
        },
        
	}
});