function changeColor(cellID)
{
var color=document.getElementById(cellID).style.backgroundColor;
if(color=="crimson"||color=="CornflowerBlue"||color=="green")
{
 alert("already colored "+color+"!");
}
else
{
 if(document.getElementById("red").checked)
 {
  document.getElementById(cellID).style.backgroundColor = "crimson";
 }
 else if(document.getElementById("blue").checked)
 {
  document.getElementById(cellID).style.backgroundColor = "CornflowerBlue";
 }
 else if(document.getElementById("green").checked)
 {
  document.getElementById(cellID).style.backgroundColor = "green";
 }
 else
 {
 alert("Please select a color");
 }
}

}

function resetColor()
{

var i;
for(i=1;i<=9;i++)
{
var cellID = "cell"+i;
document.getElementById(cellID).style.backgroundColor = "Lavender";
document.getElementById(cellID).innerHTML = i;
}
}

function shuffle()
{
var i;
for(i=1;i<=9;i++)
{
//slecting two random cells
var anotherCell = "cell"+(Math.floor((Math.random() * 9))+1);
var cell = "cell"+(Math.floor((Math.random() * 9))+1);
//interchanging the color and text of those two cell
var tempcolor = document.getElementById(cell).style.backgroundColor;
var tempnumber = document.getElementById(cell).innerHTML;
document.getElementById(cell).style.backgroundColor=document.getElementById(anotherCell).style.backgroundColor;
document.getElementById(cell).innerHTML=document.getElementById(anotherCell).innerHTML;
document.getElementById(anotherCell).innerHTML=tempnumber;
document.getElementById(anotherCell).style.backgroundColor=tempcolor;
}
}
