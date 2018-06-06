function onReady() {
    $("#signin").click(function(){
        loadDoc();
    });
}

function loadDoc() {
    $.ajax(
        {
            dataType: "json",
            type: 'POST',
            data: dataToJSON($("#username").val(),$("#password").val()),
            contentType: 'application/json',
            url: getContextPath()+"/app/Users/login",
            success: function(data){
                if(data == 'Professor'||  data == 'Student'){
                    if(typeof(Storage) !== 'undefined') {
                        window.location.replace('index1.jsp');
                    }else{
                        document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
                    }
                }else{
                    alert("Invalid Login")
                }
            },
        });
}

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

function dataToJSON(username,password){
    var str = JSON.stringify({
        "username": username,
        "password": password
    });
    console.log(str);
    return str;
}