function pageReady() {
    $("#register").click(function(){
        loadDoc();
    });
}

function loadDoc() {
    $.ajax(
        {
            datatype: "json",
            type: 'POST',
            data: dataToJSON($("#username").val(),$("#password").val(),$("#usertype").val()),
            contentType: 'application/json',
            url: getContextPath()+"/app/Users/Signup",
            success: function(data, textStatus, jqXHR){
                if(data == 'Success'){
                    window.location.replace('index.jsp');
                }else{
                    alert("Registration Failed")
                }
            },
        });
}

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

function dataToJSON(username,password,usertype){
    var str = JSON.stringify({
        "username": username,
        "password": password,
        "usertype": usertype
    });
    return str;
}