package docongphuc.pttravle.data

class LichTrinh_data_event {
    constructor()

    // lich ke hoach
    constructor(key : String, ten: String, time_BD: Long, time_KT: Long, note: String) {
        this.key = key
        this.ten = ten
        this.time_BD = time_BD
        this.time_KT = time_KT
        this.note = note
    }

    var key : String = ""
    var ten : String = ""
    var time_BD : Long = 0
    var time_KT : Long = 0
    var note : String = ""
}