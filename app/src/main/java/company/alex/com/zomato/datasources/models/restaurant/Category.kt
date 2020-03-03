package company.alex.com.zomato.datasources.models.restaurant

import android.os.Parcel
import android.os.Parcelable

data class Category(val categories: Categories) : Parcelable {
    constructor(source: Parcel) : this(
        source.readParcelable<Categories>(Categories::class.java.classLoader)!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(categories, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Category> = object : Parcelable.Creator<Category> {
            override fun createFromParcel(source: Parcel): Category = Category(source)
            override fun newArray(size: Int): Array<Category?> = arrayOfNulls(size)
        }
    }
}