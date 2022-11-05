package com.thejohnsondev.intelegentdecisionmakingsystems.lab1.domain.util

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import com.github.adriankuta.datastructure.tree.TreeNode
import com.thejohnsondev.intelegentdecisionmakingsystems.R
import com.thejohnsondev.intelegentdecisionmakingsystems.common.util.SIZE_16
import com.thejohnsondev.intelegentdecisionmakingsystems.common.util.SIZE_32
import com.thejohnsondev.intelegentdecisionmakingsystems.common.util.onClick


fun generateUserChoices(
    context: Context,
    rootView: ViewGroup,
    treeNode: TreeNode<String>,
    onBtnClick: (node: TreeNode<String>) -> Unit
) {
    if (rootView.children.any { it.tag == treeNode.value }) return

    val optionButton = TextView(ContextThemeWrapper(context, R.style.RegularRoundedButton)).also {
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(SIZE_16, SIZE_32, SIZE_16, SIZE_32)
        it.layoutParams = params
    }.apply {
        text = treeNode.value
        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        gravity = Gravity.CENTER
    }
    optionButton.tag = treeNode.value
    optionButton.onClick {
        onBtnClick.invoke(treeNode)
    }
    rootView.addView(optionButton)
}