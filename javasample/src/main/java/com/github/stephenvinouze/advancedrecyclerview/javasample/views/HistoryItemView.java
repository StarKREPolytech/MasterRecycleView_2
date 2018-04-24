package com.github.stephenvinouze.advancedrecyclerview.javasample.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.stephenvinouze.advancedrecyclerview.javasample.R;
import com.github.stephenvinouze.advancedrecyclerview.javasample.models.History;

/**
 * @author Игорь Гулькин 24.04.2018
 *
 * Класс HistoryItemView является классом разметки
 * для элемента истории.
 */

public final class HistoryItemView extends FrameLayout {

    private TextView indexTextView;

    private TextView nameTextView;

    private TextView tickIconView;

    private ImageView selectionIconView;

    //Конструкторы:

    /**
     * @param context - объект, который предоставляет
     * доступ к базовым функциям приложения: доступ к
     * ресурсам, к файловой системе вызов активности и т.д.
     *
     * @param attributeSet - набор атрибутов, найденный в
     * теге в XML-документе.
     */

    public HistoryItemView(final Context context, final AttributeSet attributeSet) {
        super(context, attributeSet);
        this.initViews();
    }

    /**
     * @param context - объект, который предоставляет
     * доступ к базовым функциям приложения: доступ к
     * ресурсам, к файловой системе вызов активности и т.д.
     */

    public HistoryItemView(final Context context) {
        super(context);
        this.initViews();
    }

    /**
     * @param history экземпляр класса истории;
     * @param isToggled помечен галочкой.
     */

    @SuppressLint("DefaultLocale")
    public final void bind(final History history, final boolean isToggled) {
        if (history != null) {
            this.indexTextView.setText(String.format("%d", history.getId()));
            this.nameTextView.setText(history.getName());
        }
        this.tickIconView.setVisibility(isToggled ? VISIBLE : GONE);
    }

    private void initViews() {
        final View view = inflate(getContext(), R.layout.sample_item_view, this);
        this.indexTextView = view.findViewById(R.id.history_item_index_text_view);
        this.nameTextView = view.findViewById(R.id.history_item_name_text_view);
        this.tickIconView = view.findViewById(R.id.history_item_name_tick_view);
        this.selectionIconView = view.findViewById(R.id.history_selection_cell_view);
    }


    public final TextView getTickIconView() {
        return tickIconView;
    }

    public final ImageView getSelectionIconView() {
        return selectionIconView;
    }
}