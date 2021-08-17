
function getBotResponse(input) {
    
    if (input == "<i id='chat-icon' style='color: crimson;'' class='fa fa-fw fa-heart'></i>") {
        return "MlemMlem yêu bạn <i id='chat-icon' style='color: crimson;'' class='fa fa-fw fa-heart'></i>";
    } else if (input.includes("Mlem") == true) {
        return "MlemMlem là trang website dạy nấu ăn trực tuyến hàng đầu Việt Nam....";
    } else if (input.includes("Khóa học") == true) {
        return "Bạn cần chúng tôi tư vấn về khóa học nào";
    }
     if (input == "MlemMlem là gì?") {
        return "MlemMlem là trang website dạy nấu ăn trực tuyến hàng đầu Việt Nam....";
    }

    if (input.includes("chào") == true) {
        return "Xin chào tôi là BotMlem!";
    } else if (input.includes("Tạm biệt") == true) {
        return "Hẹn gặp lại bạn!";
    } else {
        return "Bạn hãy hỏi chúng tôi những câu hỏi khác!";
    }
}