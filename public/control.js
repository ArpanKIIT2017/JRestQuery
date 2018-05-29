window.onload=function(){
    document.getElementById("autoclicked").hidden=true;
};



function readData()
{
    
	var qid=document.getElementById('qid').value;
    var query=document.getElementById('query').value;
    
    var xhttp = new XMLHttpRequest();

    xhttp.onload = function() {
        if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
            document.getElementById("autoclicked").click();
            document.getElementById('qid').value="";
            document.getElementById('query').value="";
        }
      };

    var url = "localhost:8080/newQuery?qid="+qid+"&&query="+query;
    xhhtp.open("GET",url,true);

    xhttp.send();  



    
}
