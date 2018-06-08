function pageReady() {
    $("form#assignmentfile").submit(function(e) {
        e.preventDefault();
        var formData = new FormData(this);

        $.ajax({
            url: getContextPath()+"/app/Assignment/AddAssignment",
            type: 'POST',
            data: formData,
            success: function (data) {
                if(data == 'Perfect'){
                    window.location.replace('assignments.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('assignments.jsp');
                }
            },
            cache: false,
            contentType: false,
            processData: false
        });
    });

    $("#delete").click(function(){
        deletefunction();
    });
}


function deletefunction() {
    $.ajax(
        {
            datatype: "text",
            type: 'DELETE',
            contentType: 'text/plain',
            url: getContextPath()+"/app/Assignment/DeleteAssignment" + '/' + $("#Assignment-ID").val(),
            success: function(data){
                if(data == 'Removed'){
                    window.location.replace('assignments.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('assignments.jsp');
                }
            },
        });

}

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}
