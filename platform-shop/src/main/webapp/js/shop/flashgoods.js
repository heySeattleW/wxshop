$(function () {
    $("#jqGrid").Grid({
        url: '../flashgoods/list',
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true},
			{label: '', name: '商品', index: 'goods_id', width: 80},
			{label: '', name: '开始时间', index: 'start_time', width: 80},
			{label: '', name: '结束时间', index: 'end_time', width: 80},
			{label: '', name: '折扣', index: 'rebate', width: 80}]
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
		title: null,
		goodss: [],
		flashgoods: {},
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
			vm.getGoodss();
			vm.flashgoods = {};
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
            let url = vm.flashgoods.id == null ? "../flashgoods/save" : "../flashgoods/update";
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.flashgoods),
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
				    url: "../flashgoods/delete",
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
                url: "../flashgoods/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.flashgoods = r.flashgoods;
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
		getGoodss: function () {
            Ajax.request({
                url: "../goods/queryAll/",
                async: true,
                successCallback: function (r) {
                    vm.goodss = r.list;
                }
            });
        }
	}
});