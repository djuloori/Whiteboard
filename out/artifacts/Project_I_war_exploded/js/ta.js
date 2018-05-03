function pageReady() {
    $("#add").click(function(){
        loadDoc();
    });

    $("#remove").click(function(){
        deletefunction();
    });
}



function loadDoc() {
    $.ajax(
        {
            datatype: "json",
            type: 'POST',
            data: dataToJSON($("#ID").val(),$("#name").val(),$("#email").val(),$("#class_id1").val(),$("#day").val(), $("#contact").val(),$("#timings").val()),
            contentType: 'application/json',
            url: getContextPath()+"/app/Ta/AddTa",
            success: function(data){
                if(data == 'Ta Added'){
                    window.location.replace('Ta.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('Ta.jsp');
                }
            },
        });
}


function deletefunction() {
    $.ajax(
        {
            datatype: "text",
            type: 'DELETE',
            contentType: 'text/plain',
            url: getContextPath()+"/app/Ta/DeleteTa" + '/' + $("#ID").val(),
            success: function(data){
                if(data == 'Ta Removed'){
                    window.location.replace('Ta.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('Ta.jsp');
                }
            },
        });

}

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

function dataToJSON(ID,name,email,classid,day,contact,timings){
    var str = JSON.stringify({
        "taTimings": timings,
        "taName": name,
        "taPhone": contact,
        "taEmail" : email,
        "CLASS_ID": classid,
        "day": day,
        "taId": ID
    });
    return str;
}