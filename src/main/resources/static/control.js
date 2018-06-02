window.onload=function(){
    document.getElementById("autoclicked").hidden=true;
    GetData();
};



function readData()
{
    
	var qid=document.getElementById('qid').value;
    var query=document.getElementById('query').value;

    var len = query.length;
    
    if(query.charAt(len-1)==';'){
        query=query.substring(0,len-1);
    }
    
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("autoclicked").click();
            document.getElementById('qid').value="";
            document.getElementById('query').value="";
        }
      };

    var url = "newQuery";
    var params = "qid="+qid+"&query="+query;
    xhttp.open("POST",url,true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send(params);

}

function GetData()
{
    var data;

    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var data_string=this.responseText;
            data = JSON.parse(data_string);
            renderDataView(data);
        }
      };

    var url = "queries";
    xhttp.open("GET",url,true);
    xhttp.send();    
}

function renderDataView(data)
{
    var code_view="";

    data.forEach(entry => {
        code_view = code_view+"<div class='jumbotron'><h4>"+entry.Query_id+"</h4><hr>"+entry.Query+"<hr><button class='btn btn-danger' id='delBut' onclick='return delQuery(\""+entry.Query_id+"\")'>Delete</button></div>";
    });

    document.getElementById("showData").innerHTML=code_view;
}

function delQuery(id)
{
    if(confirm("Are you sure you want to delete this Query?"))
    {  
        var xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
            GetData();
          }
        };

        var url = "delQuery/"+id;
        xhttp.open("DELETE",url,true);

        xhttp.send();  
    }
    
}

