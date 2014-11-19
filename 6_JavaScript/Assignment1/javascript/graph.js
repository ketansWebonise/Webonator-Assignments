function getData()
{
var inbound = document.getElementById('inbound').value;
var outbound = document.getElementById('outbound').value;
var equation = document.getElementById('equation').value;
var step = document.getElementById('step').value;

var myGraph = Object.create(Graph);
myGraph.constructor(step,equation,inbound,outbound);
myGraph.draw();
//alert(inbound+" "+outbound+" "+equation+" "+step);
}



var Graph = {

constructor: function(step,equation,start_point,end_point){
	this._step = step;
	this._equation = equation;
	this._start_point = start_point;
	this._end_point = end_point;
},

draw: function()
{
//extracting coeficient and constant from the equation.

var regex=new RegExp(/(\W|\w|\s)+(\+|\-)(\d+)$/);
var regex1=new RegExp("[0-9]*(?=x)");
this._equation = this._equation.replace(/\s/g,'');
var coef = parseInt(this._equation.charAt(this._equation.search(regex1)));

var constant = parseInt(this._equation.replace(regex,"$2$3"));

//validating the inputs
if(isNaN(coef)||isNaN(constant))
{
alert("Invalid Equation!");
location.reload();
}
if(isNaN(parseInt(this._start_point))||isNaN(parseInt(this._end_point)))
{
alert("Invalid inbound/outbound given!");
location.reload();

}
if(isNaN(parseInt(this._step)))
{
alert("Invalid Step Size given!");
location.reload();
}

//plotting the line
 
      var canvas = document.getElementById('myCanvas');
      var context = canvas.getContext('2d');
      var canvas1 = document.getElementById('myCanvas');
      var context1 = canvas.getContext('2d');
      var x_transit = canvas.width/2;
      var y_transit = canvas.height/2;
      var x = parseInt(this._start_point);
      var y = -(x*coef)+constant;
      alert(x+" "+y);
      var context1 = canvas.getContext('2d');		//plotting the coordinates
     context1.fillStyle ='blue';
      context.lineWidth = 2;
     
     context1.beginPath();
     context1.moveTo(x+x_transit,y+y_transit);
     context.moveTo(x+x_transit,y+y_transit);
     context1.arc(i, y, 2, 0, 2 * Math.PI, false);
     context.fill();
    var i=parseInt(this._start_point)+parseInt(this._step);
 while(i<= parseInt(this._end_point))
      {

      var actual_x = i+x_transit;
      y = -(i*coef)+constant;
      y+=y_transit;		
      
      context.lineTo(actual_x,y);
      context.stroke();
      context1.lineWidth = 1;
      context1.arc(actual_x, y, 2, 0, 2 * Math.PI, false);						//plotting intermediate points
      context1.fill();
      context1.font("20px Verdana");
      context1.filltext(""+i+", "+(y-y_transit),actual_x-7,y-7);
      context1.moveTo(actual_x,y);
      i=i+parseInt(this._step);

      }
} 
}
