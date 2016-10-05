/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function showMessage(){
   alert("Hello World!");	
}

function showMessage2(str){
    var cadena=str;
   alert(cadena);	
}

function fecha(){
    var d = new Date();
                    document.write(d.getDate());
}



function initMap() {
  // Create a map object and specify the DOM element for display.
  var map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: -34.397, lng: 150.644},
    scrollwheel: false,
    zoom: 8
  });
}



