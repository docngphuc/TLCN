package docongphuc.pttravle.data

class LichTrinh_data_list {
    constructor()

    // lich ke hoach
    constructor(ten: String, note: String, ngayBD: String, ngayKT: String, gioBD: String, gioKT: String) {
        this.ten = ten
        this.note = note
        this.ngayBD = ngayBD
        this.ngayKT = ngayKT
        this.gioBD = gioBD
        this.gioKT = gioKT
    }

    var ten : String = ""
    var note : String = ""

    var ngayBD : String = ""
    var ngayKT : String = ""
    var gioBD : String = ""
    var gioKT : String = ""
}