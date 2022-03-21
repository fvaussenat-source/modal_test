package com.example.modal_test

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class ConfirmDeleteDialogFragment : DialogFragment() {

    interface ConfirmDeleteListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    val TAG = ConfirmDeleteDialogFragment::class.java.simpleName

    var listener: ConfirmDeleteListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)

        builder.setMessage("Supprimer tout le contenu du téléphone ?")
            .setPositiveButton("Oui avec grand plaisir", object: DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, id: Int) {
                    Log.i(TAG, "youpi on va tout casser!")
                    listener?.onDialogPositiveClick()
                }
            })
            .setNegativeButton("Euh... non", DialogInterface.OnClickListener { dialog, id ->
                Log.i(TAG, "Bon ben ce sera pour la prochaine fois")
                listener?.onDialogNegativeClick()
            } )

        return builder.create()

    }


}