
function getBotResponse1(input) {
    
    if (input == "<i id='chat-icon' style='color: crimson;'' class='fa fa-fw fa-heart'></i>") {
        return "MlemMlem yêu bạn <i id='chat-icon' style='color: crimson;'' class='fa fa-fw fa-heart'></i>";
    } else if (input.includes("Mlem")) {
        return "MlemMlem là trang website dạy nấu ăn trực tuyến hàng đầu Việt Nam....";
    } else if (input.includes("Khóa học")) {
        return "Bạn cần chúng tôi tư vấn về khóa học nào";
    }
     if (input == "MlemMlem là gì?") {
        return "MlemMlem là trang website dạy nấu ăn trực tuyến hàng đầu Việt Nam....";
    }

    if (input.includes("chào") == true) {
        return "Xin chào tôi là <strong>BotMlem!</strong>";
    }else if (input.indexOf("yêu")>-1) {
        return "Tôi yêu bạn niều hơn tôi nghĩ!";
    }
     else if (input.includes("Tạm biệt") == true) {
        return "Hẹn gặp lại bạn!";
    } else{
        return "Bạn hãy hỏi chúng tôi những câu hỏi khác!<br><a style='color:#F4A460 !important' href='#'>http://hoccaigi-nghidi</a>";
    } 
}