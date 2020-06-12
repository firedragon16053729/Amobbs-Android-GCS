package org.farring.gcs.dialogs

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import org.farring.gcs.R
import org.farring.gcs.fragments.actionbar.SelectionListAdapter

/**
 * Created by Fredia Huya-Kouadio on 9/25/15.
 */
abstract class SelectionListDialog : DialogFragment(), SelectionListAdapter.SelectionListener {

    companion object {
        @JvmStatic fun newInstance(viewAdapter: SelectionListAdapter<*>?): SelectionListDialog {
            val selectionsDialog = object : SelectionListDialog() {
                override fun getSelectionsAdapter() = viewAdapter
            }

            viewAdapter?.setSelectionListener(selectionsDialog)
            return selectionsDialog
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, 0)
        isCancelable = true
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.dialog_selection_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectionsView = view.findViewById(R.id.selection_list) as ListView?
        val adapter = getSelectionsAdapter()
        selectionsView?.adapter = adapter
        if (adapter != null)
            selectionsView?.setSelection(adapter.selection)
    }

    override fun onStart() {
        super.onStart()
        dialog.setCanceledOnTouchOutside(true)
    }

    override fun onPause() {
        super.onPause()
        dismiss()
    }

    override fun onSelection() {
        dismiss()
    }

    abstract fun getSelectionsAdapter(): SelectionListAdapter<*>?
}