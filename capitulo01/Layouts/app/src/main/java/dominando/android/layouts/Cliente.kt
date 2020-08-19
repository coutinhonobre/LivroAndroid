package dominando.android.layouts

import android.os.Parcel
import android.os.Parcelable

class Cliente(var codigo: Int, var nome: String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(), parcel.readString()!!
    ){}

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(codigo)
        dest?.writeString(nome)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Cliente> {
        override fun createFromParcel(parcel: Parcel): Cliente {
            return Cliente(parcel)
        }

        override fun newArray(size: Int): Array<Cliente?> {
            return arrayOfNulls(size)
        }
    }

}