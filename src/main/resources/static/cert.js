const userName = document.getElementById("name");
const submitBtn = document.getElementById("submitBtn");
const typeCourse = document.getElementById("typeCourse");
const nameCourse = document.getElementById("nameCourse");


var today = new Date();
var date = 'Đà Nẵng,Ngày ' + today.getDate() + ' Tháng ' + (today.getMonth() + 1) + ' Năm ' + today.getFullYear();

const {
    PDFDocument,
    rgb,
    degrees
} = PDFLib;


const capitalize = (str, lower = false) =>
    (lower ? str.toLowerCase() : str).replace(/(?:^|\s|["'([{])+\S/g, (match) =>
        match.toUpperCase()
    );

submitBtn.addEventListener("click", () => {
    const val = capitalize(userName.value);

    //check if the text is empty or not
    if (val.trim() !== "" && userName.checkValidity()) {
        // console.log(val);
        generatePDF(val);
    } else {
        userName.reportValidity();
    }
});

const generatePDF = async(name) => {
    const existingPdfBytes = await fetch("./cert2.pdf").then((res) =>
        res.arrayBuffer()
    );


    // Load a PDFDocument from the existing PDF bytes
    const pdfDoc = await PDFDocument.load(existingPdfBytes);
    pdfDoc.registerFontkit(fontkit);
    //get font
    const fontBytes = await fetch("./DancingScript-VariableFont_wght.ttf").then((res) =>
        res.arrayBuffer()
    );
    const fontBytes1 = await fetch("./font-times-new-roman.ttf").then((res) =>
        res.arrayBuffer()
    );

    // Embed our custom font in the document
    const SanChezFont = await pdfDoc.embedFont(fontBytes);
    const Timenew = await pdfDoc.embedFont(fontBytes1);



    const textWidth = SanChezFont.widthOfTextAtSize(userName.value, 48);
    // Get the first page of the document
    const pages = pdfDoc.getPages();
    const firstPage = pages[0];


    // Draw a string of text diagonally across the first page
    firstPage.drawText(name, {
        x: firstPage.getWidth() * 2 / 3.15 - textWidth / 2,
        y: 400,
        size: 48,
        font: SanChezFont,
        color: rgb(0.0, 0.0, 0.0),

    });
    var nameCourse1 = 'Đã hoàn thành khoá học ' + '"' + nameCourse.value + '"';
    firstPage.drawText(nameCourse1, {
        x: 280,
        y: 310,
        size: 20,
        font: Timenew,
        color: rgb(0.0, 0.0, 0.0),
    });
    var nameCourse2 = 'Has successfully completed the course ' + '"' + nameCourse.value + '"';
    firstPage.drawText(nameCourse2, {
        x: 280,
        y: 280,
        size: 22,
        font: SanChezFont,
        color: rgb(0.0, 0.0, 0.0),
    });



    firstPage.drawText(typeCourse.value, {
        x: 320,
        y: 160,
        size: 22,
        font: SanChezFont,
        color: rgb(0.35, 0.15, 0.13),
    });

    firstPage.drawText(date, {
        x: 300,
        y: 130,
        size: 14,
        font: Timenew,
        color: rgb(0.35, 0.15, 0.13),
    });
    var chuky = "Xác nhận tại Mlemmlem.com/Certification/"
    firstPage.drawText(chuky, {
        x: 40,
        y: 40,
        size: 10,
        font: Timenew,
        color: rgb(0.0, 0.0, 0.0),
    });

    // Serialize the PDFDocument to bytes (a Uint8Array)
    const pdfBytes = await pdfDoc.save();
    console.log("Done creating");

    var namefix = userName.value.normalize('NFD').replace(/[\u0300-\u036f]/g, '').replace(/đ/g, 'd').replace(/Đ/g, 'D').replace(/\s/g, '');
    var file = new File(
        [pdfBytes],
        namefix + ".pdf", {
            type: "application/pdf;charset=utf-8",
        }
    );
    saveAs(file);
};

// init();