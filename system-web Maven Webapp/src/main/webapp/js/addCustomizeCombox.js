UE.registerUI('combox', function(editor, uiName) {

	// 注册下拉菜单时执行时的command命令
	editor.registerCommand(uiName, {
				execCommand : function(cmdName, value) {
					// this.execCommand('fontsize', value + 'px')
					this.execCommand('inserthtml', '{' + value + '}');
				},
				queryCommandValue : function() {
					// return this.queryCommandValue('fontsize')
				}
			});

	var contractParam=JSON.parse($("#params").val());
	console.log(contractParam);
	// 创建下拉菜单中的选项
	var items = [];
	// 合同参数
	var params = contractParam;
	for (var i = 0; param = params[i++];) {
		items.push({
			label : param,
			value : param,
			renderLabelHtml : function() {
				return '<div class="edui-label %%-label" style="line-height:1.3;width:150px;font-size:'
						+ 11 + 'px;">' + (this.label || '') + '</div>';
			}
		});
	}

	// 创建一个下拉菜单
	var combox = new UE.ui.Combox({
				title : '合同参数',
				// 当编辑器没有焦点时，combox默认显示的内容
				initValue : '合同参数',
				editor : editor,
				items : items,
				onselect : function(t, index) {
					editor.execCommand(uiName, this.items[index].value);
				}
			});

	// 当点到编辑内容上时，按钮要做的状态反射
	editor.addListener('selectionchange', function(type, causeByUi, uiReady) {
				if (!uiReady) {
					var state = editor.queryCommandState(uiName);
					if (state == -1) {
						combox.setDisabled(true);
					} else {
						combox.setDisabled(false);
						// 使用第一步注册的查询命令
						// var value = editor.queryCommandValue(uiName);
						var value = "合同参数";
						if (!value) {
							combox.setValue(uiName);
							return;
						}
						combox.setValue(value);
					}
				}

			});

	return combox;
});
UE.registerUI('button', function(editor, uiName) {
			// 注册按钮执行时的command命令，使用命令默认就会带有回退操作
			editor.registerCommand(uiName, {
						execCommand : function() {
							
						}
					});
			// 创建一个button
			var btn = new UE.ui.Button({
						// 按钮的名字
						name : uiName,
						// 提示
						title : "保存",
						// 添加额外样式，指定icon图标，这里默认使用一个重复的icon
						//cssRules : 'background-position: -50px 0;',
						cssRules : 'background:url(js/ueditor/themes/default/images/2.jpg);',
						// 点击时执行的命令
						onclick : function() {
							// 这里可以不用执行命令,做你自己的操作也可
							editor.execCommand(uiName);
						}
					});
			// 当点到编辑内容上时，按钮要做的状态反射
			editor.addListener('selectionchange', function() {
						var state = editor.queryCommandState(uiName);
						if (state == -1) {
							btn.setDisabled(true);
							btn.setChecked(false);
						} else {
							btn.setDisabled(false);
							btn.setChecked(state);
						}
					});
			// 因为你是添加button,所以需要返回这个button
			return btn;
		});
