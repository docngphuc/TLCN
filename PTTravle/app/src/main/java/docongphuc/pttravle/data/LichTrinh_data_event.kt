package docongphuc.pttravle.data

/**
 * Created by user on 21-Oct-17.
 */
class LichTrinh_data_event {
    constructor()

    // lich ke hoach
    constructor(ten: String, time_BD: Long, time_KT: Long, note: String) {
        this.ten = ten
        this.time_BD = time_BD
        this.time_KT = time_KT
        this.note = note
    }

    var ten : String = ""
    var time_BD : Long = 0
    var time_KT : Long = 0
    var note : String = ""

    var ngayBD : String = ""
    var ngayKT : String = ""
    var gioBD : String = ""
    var gioKT : String = ""
}