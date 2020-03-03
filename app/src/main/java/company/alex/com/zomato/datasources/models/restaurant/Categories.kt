package company.alex.com.zomato.datasources.models.restaurant

import android.os.Parcel
import android.os.Parcelable

data class Categories(var id: Int, var name: String) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Categories> = object : Parcelable.Creator<Categories> {
            override fun createFromParcel(source: Parcel): Categories = Categories(source)
            override fun newArray(size: Int): Array<Categories?> = arrayOfNulls(size)
        }
    }
}