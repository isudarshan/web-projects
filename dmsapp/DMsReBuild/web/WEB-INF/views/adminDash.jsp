
<!DOCTYPE html>
<html>
    <head>

        <title>
            Post Internal Marks
        </title>

        <!-- Meta Tags -->
        <meta charset="utf-8">
        <meta name="generator" content="Wufoo">
        <meta name="robots" content="index, follow">

        <!-- CSS -->
        <link href="${pageContext.request.contextPath}/resources/css/structure.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/form.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/theme.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/jquery-ui/south-street/jquery-ui-1.10.3.custom.css"/>
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/ui.jqgrid.css"/>
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/style.css"/>



        <!-- JavaScript -->
        <script src="${pageContext.request.contextPath}/resources/scripts/wufoo.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.2.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-ui-1.10.3.custom.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/grid.locale-en-4.3.1.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery.jqGrid.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/custom.js"></script>


        <script type="text/javascript">

            $(document).ready(function(){


                $("#grid").jqGrid({
                    url:'${pageContext.request.contextPath}/adminDash/crud',
                    datatype: 'json',
                    mtype: 'GET',

                    colNames:['Id', 'Year', 'Branch', 'Semister', 'Paper', 'Paper Code'],


                    colModel:[
                        {name:'id',index:'id', width:55,editable:false,editoptions:{readonly:true,size:10},hidden:true},
                        {name:'year',index:'year', width:25,editable:true, editrules:{required:true}, editoptions:{size:50}},
                        {name:'branch',index:'branch', width:30,editable:true, editrules:{required:true}, editoptions:{size:50}},
                        {name:'semister',index:'semister', width:25,editable:true, editrules:{required:true}, editoptions:{size:50}},
                        {name:'paper',index:'paper', width:150,editable:true, editrules:{required:true}, editoptions:{size:50}},
                        {name:'paperCode',index:'paperCode', width:30,editable:true, editrules:{required:true}, editoptions:{size:50}},


                    ],
                    postData: {
                    },
                    rowNum:20,
                    rowList:[20,40,60,80,100],
                    height: 400,
                    autowidth: true,
                    rownumbers: true,
                    pager: '#pager',
                    sortname: 'id',
                    viewrecords: true,
                    sortorder: "asc",
                    caption:"",
                    emptyrecords: "Empty records",
                    loadonce: false,

                    loadComplete: function() {
                    },
                    jsonReader : {
                        root: "rows",
                        page: "page",
                        total: "total",
                        records: "records",
                        repeatitems: false,
                        cell: "cell",
                        id: "id"
                    }
                });
                $("#grid").jqGrid('navGrid','#pager',
                {edit:false,add:false,del:false,search:false},
                { },
                { },
                { },
                {
                    sopt:['eq', 'ne', 'lt', 'gt', 'cn', 'bw', 'ew'],
                    closeOnEscape: true,
                    multipleSearch: true,
                    closeAfterSearch: true }
            );



                $("#grid").navButtonAdd('#pager',
                { 	caption:"Add",
                    buttonicon:"ui-icon-plus",
                    onClickButton: addRow,
                    position: "last",
                    title:"",
                    cursor: "pointer"
                }
            );

                $("#grid").navButtonAdd('#pager',
                { 	caption:"Edit",
                    buttonicon:"ui-icon-pencil",
                    onClickButton: editRow,
                    position: "last",
                    title:"",
                    cursor: "pointer"
                }
            );

                $("#grid").navButtonAdd('#pager',
                { 	caption:"Delete",
                    buttonicon:"ui-icon-trash",
                    onClickButton: deleteRow,
                    position: "last",
                    title:"",
                    cursor: "pointer"
                }
            );

                $("#btnFilter").click(function(){
                    jq("#grid").jqGrid('searchGrid',
                    {multipleSearch: false,
                        sopt:['eq']}
                );
                });

                // Toolbar Search
                //$("#grid").jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true, defaultSearch:"cn"});

            });


        </script>

        <script type="text/javascript">

            function addRow() {

                // Get the currently selected row
                $("#grid").jqGrid('editGridRow','new',
                { 	url: "${pageContext.request.contextPath}/adminDash/add",
                    editData: {
                    },
                    recreateForm: true,
                    beforeShowForm: function(form) {
                    },
                    closeAfterAdd: true,
                    reloadAfterSubmit:false,
                    afterSubmit : function(response, postdata)
                    {
                        var result = eval('(' + response.responseText + ')');
                        var errors = "";

                        if (result.success == false) {
                            for (var i = 0; i < result.message.length; i++) {
                                errors +=  result.message[i] + "<br/>";
                            }
                        }  else {
                            $("#dialog").text('Entry has been added successfully');
                            $("#dialog").dialog(
                            {	title: 'Success',
                                modal: true,
                                buttons: {"Ok": function()  {
                                        $(this).dialog("close");}
                                }
                            });
                        }
                        // only used for adding new records
                        var new_id = null;

                        return [result.success, errors, new_id];
                    }
                });

            }

            function editRow() {
                // Get the currently selected row
                var row = $("#grid").jqGrid('getGridParam','selrow');

                if( row != null )
                    $("#grid").jqGrid('editGridRow',row,
                {	url: "${pageContext.request.contextPath}/adminDash/edit",
                    editData: {
                    },
                    recreateForm: true,
                    beforeShowForm: function(form) {
                    },
                    closeAfterEdit: true,
                    reloadAfterSubmit:false,
                    afterSubmit : function(response, postdata)
                    {
                        var result = eval('(' + response.responseText + ')');
                        var errors = "";

                        if (result.success == false) {
                            for (var i = 0; i < result.message.length; i++) {
                                errors +=  result.message[i] + "<br/>";
                            }
                        }  else {
                            $("#dialog").text('Entry has been edited successfully');
                            $("#dialog").dialog(
                            {	title: 'Success',
                                modal: true,
                                buttons: {"Ok": function()  {
                                        $(this).dialog("close");}
                                }
                            });
                        }

                        return [result.success, errors, null];
                    }
                });
                else $( "#dialogSelectRow" ).dialog();
            }

            function deleteRow() {
                // Get the currently selected row
                var row = $("#grid").jqGrid('getGridParam','selrow');

                // A pop-up dialog will appear to confirm the selected action
                if( row != null )
                    $("#grid").jqGrid( 'delGridRow', row,
                { url: '${pageContext.request.contextPath}/adminDash/delete',
                    recreateForm: true,
                    beforeShowForm: function(form) {
                        //change title
                        $(".delmsg").replaceWith('<span style="white-space: pre;">' +
                            'Delete selected record?' + '</span>');

                        //hide arrows
                        $('#pData').hide();
                        $('#nData').hide();
                    },
                    reloadAfterSubmit:false,
                    closeAfterDelete: true,
                    afterSubmit : function(response, postdata)
                    {
                        var result = eval('(' + response.responseText + ')');
                        var errors = "";

                        if (result.success == false) {
                            for (var i = 0; i < result.message.length; i++) {
                                errors +=  result.message[i] + "<br/>";
                            }
                        }  else {
                            $("#dialog").text('Entry has been deleted successfully');
                            $("#dialog").dialog(
                            {	title: 'Success',
                                modal: true,
                                buttons: {"Ok": function()  {
                                        $(this).dialog("close");}
                                }
                            });
                        }
                        // only used for adding new records
                        var new_id = null;

                        return [result.success, errors, new_id];
                    }
                });
                else $( "#dialogSelectRow" ).dialog();
            }

        </script>


    </head>

    <body >
        <div id="" class="ltr">

            <h1 id="logo">
                <a>Wufoo</a>
            </h1>

            <form id="sleectionForPost" name="form3" class="wufoo topLabel page" autocomplete="off">
                <header id="header" class="info">
                    <h2>Add, Modify and Delete Details about Paper & Paper Code</h2>
                    <div>Note : Before adding a new Branch, Add Branch Details in Database Branch Table.</div>
                </header>

            </form>
            <div id="jqgrid">
                <table id="grid"></table>
                <div id="pager"></div>
            </div>

            <div id="dialog" title="Feature not supported" style="display:none">
                <p>That feature is not supported.</p>
            </div>

            <div id="dialogSelectRow" title="Warning" style="display:none">
                <p>Please select row</p>
            </div>

            <br/>

            <div style="position:relative;height:40px;">
                <center>
                    <a href="${pageContext.request.contextPath}/home" class="powertiny">Cancel</a>
                </center>
            </div>

        </div><!--container-->

        <a class="powertiny" href="#" title=""
           style="display:block !important;visibility:visible !important;text-indent:0 !important;position:relative !important;height:auto !important;width:95px !important;overflow:visible !important;text-decoration:none;cursor:pointer !important;margin:0 auto !important">

            <b style="display:block !important;visibility:visible !important;text-indent:0 !important;position:static !important;height:auto !important;width:auto !important;overflow: auto !important;font-weight:normal;font-size:9px;color:#777;padding:0 0 0 3px;">Designed</b>
        </a>
    </body>
</html>