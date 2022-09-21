var a = 5;
let b = "kampus merdeka";
const nama = "Budi";
let terdaftar  =true;
let lengkap_arr = [a, b, nama, terdaftar];

function perkenalan() {
    let asal = "Indonesia";
    return console.log(
        "perkenalan nama saya " +
        nama + 
        " nomor urut " + 
        a + 
        " sekarang sedang mengikuti "+
        b +
        "berasal dari " +
        asal
    );
}

if(terdaftar) {
    console.log(nama + " terdaftar sebagai kegiatan kampus merdeka");
}
console.log("array = " + lengkap_arr[2])
a = b;
// nama = b;
// console.log("asal diakses = "+ asal);
console.log("a adalah = "+ a);
console.log("b adalah = "+ b);
perkenalan();