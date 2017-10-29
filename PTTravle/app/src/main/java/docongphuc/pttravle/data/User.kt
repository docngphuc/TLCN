package docongphuc.pttravle.data

class User {
    var id : String = ""
    var ten : String = ""
    var email : String = ""
    var AnhDaiDien : String = ""

    constructor()
    constructor(id: String, ten: String, email: String, AnhDaiDien: String) {
        this.id = id
        this.ten = ten
        this.email = email
        this.AnhDaiDien = AnhDaiDien
    }
}