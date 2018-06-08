function pageReady() {
    $("form#syllabusfile").submit(function(e) {
        e.preventDefault();
        var formData = new FormData(this);

        $.ajax({
            url: getContextPath()+"/app/Syllabus/AddSyllabus",
            type: 'POST',
            data: formData,
            success: function (data) {
                if(data == 'done'){
                    window.location.replace('Syllubus.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('Syllubus.jsp');
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
            url: getContextPath()+"/app/Syllabus/DeleteSyllabus" + '/' + $("#idsyllabus").val(),
            success: function(data){
                if(data == 'Syllabus Removed'){
                    window.location.replace('Syllubus.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('Syllubus.jsp');
                }
            },
        });

}

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}
