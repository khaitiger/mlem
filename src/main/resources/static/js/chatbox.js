//click on add class
var dropchat = true;
$(".chatbox").click(function () {
  if (dropchat) {
    $(".dropchat").addClass("show");
    dropchat = false;
  } else {
    $(".dropchat").removeClass("show");
    dropchat = true;

  }
});

// $(document).ready(function () {
//   var list = document.getElementsByClassName("chatbox");
//   for (var i = 0; i < list.length; i++) list[0].click();
// });

$(".close").click(function () {
  $(".dropchat").removeClass("show");
});

// disable form 
$('.typer').submit(false);

//Gets the text text from the input box and processes it
function sendButton1() {
  let userText = $("#textInput").val();

  if (userText == "") {
    userText = "MlemMlem là gì?";
  }

  let userHtml = '<div class="list revange "> <div class="chat-content" style="background-color:#5ca6fa;max-width:80%;border-radius: 10px 10px 0px 10px;"> <p style="color:white;width:100%">' + userText + '</p> </div></div><div class="list " id="chatbox"></div>';

  $("#textInput").val("");

  $("#chatbox").replaceWith(userHtml);

  document.getElementById("chatbox").scrollIntoView(true);

  setTimeout(() => {
    getHardResponse1(userText);
  }, 500)

}


// Retrieves the response
function getHardResponse1(userText) {
  let botResponse = getBotResponse1(userText);
  let botHtml = '<div class="list"> <img class="chat-avater" src="./images/fav.png" alt=""> <div class="chat-content"> <p>' + botResponse + ' </p> </div> </div><div class="list " id="chatbox"></div>';
  $("#chatbox").replaceWith(botHtml);

  document.getElementById("chatbox").scrollIntoView(true);

}



function heartButton() {
  buttonSendText1("<i id='chat-icon' style='color: crimson;'' class='fa fa-fw fa-heart'></i>")
}


// Handles sending text via button clicks
function buttonSendText1(sampleText) {
  let userText = $("#textInput").val();

  userText = sampleText;

  let userHtml = '<div class="list revange "> <div class="chat-content" style="background-color:#5ca6fa;width:80px;border-radius: 10px 10px 0px 10px;">  <p ><span style="font-size: 12px;color:white">' + sampleText + '</span></p></div></div>';

  $("#textInput").val("");
  $("#chatbox").replaceWith(userHtml + '<div class="list " id="chatbox"></div>');

  document.getElementById("chatbox").scrollIntoView(true);

  setTimeout(() => {
    getHardResponse1(userText);
  }, 500)

}


$("#textInput").keypress(function (e) {
  if (e.which == 13) {
    sendButton1();
  }
});