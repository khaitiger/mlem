function getBotResponse1(input) {
    input = input.toLowerCase();
    if (input == "<i id='chat-icon' style='color: crimson;'' class='fa fa-fw fa-heart'></i>") {
        return "MlemMlem yêu bạn <i id='chat-icon' style='color: crimson;'' class='fa fa-fw fa-heart'></i><br>Chúng tôi có thể giúp gì cho bạn!";
    } else if (input.includes("mlem")) {
        return "MlemMlem là trang website dạy nấu ăn trực tuyến hàng đầu Việt Nam....";
    }  else if (input.includes("cơ bản")) {
        return "Bạn có thể tham khảo ở đây: <br><a style='color:#F4A460 !important' href='/course_list_view.html' target='_blank'>http://MlemMlem/KhoaHocCoBan</a>";
    }
    else if (input.includes("co ban")) {
        return "Bạn có thể tham khảo ở đây: <br><a style='color:#F4A460 !important' href='/course_list_view.html' target='_blank'>http://MlemMlem/KhoaHocCoBan</a>";
    }
    else if (input.includes("trung cấp")) {
        return "Bạn có thể tham khảo ở đây: <br><a style='color:#F4A460 !important' href='/course_list_view.html' target='_blank'>http://MlemMlem/KhoaHoc</a>";
    }
    else if (input.includes("trung cap")) {
        return "Bạn có thể tham khảo ở đây: <br><a style='color:#F4A460 !important' href='/course_list_view.html' target='_blank'>http://MlemMlem/KhoaHoc</a>";
    }
    else if (input.includes("cao cấp")) {
        return "Bạn có thể tham khảo ở đây: <br><a style='color:#F4A460 !important' href='/course_list_view.html' target='_blank'>http://MlemMlem/KhoaHoc</a>";
    }
    else if (input.includes("cao cap")) {
        return "Bạn có thể tham khảo ở đây: <br><a style='color:#F4A460 !important' href='/course_list_view.html' target='_blank'>http://MlemMlem/KhoaHoc</a>";
    }
    else if (input.includes("khóa học")) {
        return "Bạn cần chúng tôi tư vấn về khóa học nào";
    }
    else if (input.includes("khoa hoc")) {
        return "Bạn cần chúng tôi tư vấn về khóa học nào";
    }
    else if(input.includes("I need advice about the Course")){
        return "Which course do you need our advice on?"
    }
    else if(input.includes("I need advice about the Course")){
        return "Which course do you need our advice on?"
    }
    if (input == "MlemMlem là gì?") {
        return "MlemMlem là trang website dạy nấu ăn trực tuyến hàng đầu Việt Nam....";
    }

    if (input.includes("chào")) {
        return "Xin chào tôi là <strong>BotMlem!</strong>";
    } else if (input.includes("tạm biệt")) {
        return "Hẹn gặp lại bạn!";
    } else {
        return "Chúng tôi có thể giúp gì cho bạn!";
    }
}