import 'dart:html';
import 'dart:math';
import 'dart:async';

CanvasElement canvas;
CanvasRenderingContext2D ctx;


var ball;

class Ball {
  var r = 15.0; //ball size
  var x = 50.0;
  var y = 50.0;
  var vx = 0.0;
  var vy = 0.0;
}

void resetOnClick(MouseEvent event){//when mouse is clicked
  
  //Keeps the ball inside the box
  if(event.offset.x < canvas.width - ball.r && event.offset.y < canvas.height - ball.r){ 
  	ball.x = event.offset.x;
  	ball.y = event.offset.y;
  	ball.vx = 0.0;//velocity
  	ball.vy = 0.0;//velocity
  }
  
}

void drawBall(){//constucts the ball
  ctx.clearRect(0,0, canvas.width, canvas.height);
  ctx.fillStyle = "rgba(0, 0, 200, .3)";
  ctx.fillRect(0, 0, canvas.width, canvas.height);
  ctx.restore();
  
  ball.x = ball.x + ball.vx;//velocity to right
  ball.y = ball.y + ball.vy;//velocity to left
  
  ball.vx = ball.vx * .996;//drag/friction to right of screen
  ball.vy = ball.vy * .996;//drag/friction to bottom of screen
  
  ball.vx = ball.vx + .07; //gravity to right of screen
  ball.vy = ball.vy + .07; //gravity to bottom of screen
  
  ctx.save();
  ctx.translate(ball.x, ball.y);
  ctx.fillStyle = "lime"; //ball color
  ctx.beginPath();
  ctx.arc(0, 0, ball.r, 0, pi*2, false);
  ctx.closePath();
  ctx.fill();
  ctx.restore();
  
  //checks if ball hits the side
  if (ball.y + ball.r > canvas.height){
    ball.y = canvas.height - ball.r;
    ball.vy = (-1) * ball.vy;
  }
  //checks if ball hits the bottom
  if(ball.x + ball.r > canvas.width){
    ball.x = canvas.width - ball.r;
    ball.vx = (-1) * ball.vx;   
    }
  
  
  
  timeWait();
}

Timer timeWait([int milliseconds]) {
  const timeout = const Duration(milliseconds: 6);//seconds between each frame
  const ms = const Duration(milliseconds: 1);
  var duration = milliseconds == null ? timeout : ms * milliseconds;
  return new Timer(duration, drawBall);
}

void main(){
  ball = new Ball();
  canvas = querySelector('#canvas');
  ctx = canvas.getContext('2d');
  drawBall();
  ctx.canvas.onClick.listen(resetOnClick);
}