<style>
  .linenums {
    white-space: nowrap;
    margin-top: 0;
    margin-bottom: 0;
  }
  .editormd .CodeMirror pre {
    font-size: 14px;
    padding: 0 33px;
  }
</style>
<template>
  <div :id="id" class="main-editor">
    <link rel="stylesheet" href="/lib/editor.md/css/editormd.min.css">
    <textarea v-model="contentLocal" style="display:none;"></textarea>
  </div>
</template>

<script>
    if (typeof window !== 'undefined') {
        var $s = require('scriptjs');
    }
    export default {
        name: 'mdEditor',
        props: {
            // width: '',
            content:{
                type: String,
                default: ''
            },
            type: {
                type:String,
                default: 'editor'
            },
            id: {
                type: String,
                default: 'editor-md'
            },
            editorConfig: {
                type: Object,
                default() {
                    return {
                        width: "100%",
                        height: 1080,
                        path : '/lib/editor.md/',
                        theme : "dark",
                        previewTheme : "dark",
                        editorTheme : "pastel-on-dark",
                        // markdown : 'fuck you',
                        codeFold : true,
                        //syncScrolling : false,
                        saveHTMLToTextarea : true,    // 保存 HTML 到 Textarea
                        searchReplace : true,
                        //watch : false,                // 关闭实时预览
                        htmlDecode : "style,script,iframe|on*",            // 开启 HTML 标签解析，为了安全性，默认不开启
                        //toolbar  : false,             //关闭工具栏
                        //previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
                        emoji : true,
                        taskList : true,
                        tocm            : true,         // Using [TOCM]
                        tex : true,                   // 开启科学公式TeX语言支持，默认关闭
                        flowChart : true,             // 开启流程图支持，默认关闭
                        sequenceDiagram : true,       // 开启时序/序列图支持，默认关闭,
                        //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
                        //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
                        //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
                        //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
                        //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
                        imageUpload : true,
                        imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                        onload : function() {
                            // console.log('onload', this);
                            //this.fullscreen();
                            // console.log(this.markdown)
                            //this.unwatch();
                            // this.markdownTextarea[0].defaultValue = "fuckyou";
                            // console.log(this)
                            //this.watch().fullscreen();

                            //this.setMarkdown("#PHP");
                            //this.width("100%");
                            //this.height(480);
                            //this.resize("100%", 640);
                            // that.detail = testEditor.getHTML();
                            // that.detail = $(that.detail);
                            // temp = $(that.detail);
                            // .ready(function() {
                            //   $('pre code').each(function(i, block) {
                            //     hljs.highlightBlock(block);
                            //   });
                            // });
                        }
                        // onchange : ()=>{
                        //     this.$emit('change',this.instance.getPreviewedHTML(),this.instance.getMarkdown())
                        // }
                    };
                },
            },
        },
        data() {
            return {
                instance: null,
                contentLocal: this.content
            };
        },
        mounted() {
            // let that = this;
            //加载依赖
            $s([
                // `/lib/jquery.min.js`,
                // `/lib/editor.md/lib/codemirror/codemirror.min.js`,
                `/lib/editor.md/lib/marked.min.js`,
                `/lib/editor.md/lib/prettify.min.js`,
                `/lib/editor.md/lib/raphael.min.js`,
                `/lib/editor.md/lib/underscore.min.js`,
            ], () => {
                $s(`/lib/editor.md/editormd.min.js`, () => {
                    this.$nextTick((editorMD = window.editormd) => {
                        if (editorMD) {
                            // console.log(that.content);
                            // that.contentLocal = that.content;
                            //type等于editor是编辑，否则展示数据
                            if (this.type == 'editor'){
                                let config = this.editorConfig;
                                config['markdown'] = this.content;
                                console.log(this.id);
                                console.log(this.contentLocal);
                                this.instance = editorMD(this.id, config);
                                // console.log(this.instance);
                                // this.instance.setMarkdown('???')
                            } else {
                                this.instance = editorMD.markdownToHTML(this.id, this.editorConfig)
                            }
                        }
                    });
                });
            });

        }
    };
</script>