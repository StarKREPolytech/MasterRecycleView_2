package com.github.stephenvinouze.advancedrecyclerview.javasample.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.github.stephenvinouze.advancedrecyclerview.core.adapters.RecyclerAdapter;
import com.github.stephenvinouze.advancedrecyclerview.javasample.models.History;
import com.github.stephenvinouze.advancedrecyclerview.javasample.views.HistoryItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen Vinouze on 09/11/2015.
 */
public class HistoryAdapter extends RecyclerAdapter<History> {

    private final List<HistoryItemView> historyItemViewList;

    public HistoryAdapter(final Context context) {
        super(context);
        this.historyItemViewList = new ArrayList<>();
    }

    @NonNull
    @Override
    protected final View onCreateItemView(final @NonNull ViewGroup parent, final int viewType) {
        return new HistoryItemView(getContext());
    }

    @Override
    public final void onBindItemView(final @NonNull View view, final int position) {
        final HistoryItemView historyItemView = (HistoryItemView) view;
        this.historyItemViewList.add(historyItemView);
        historyItemView.bind(getItems().get(position), isItemViewToggled(position));
    }

    public final List<HistoryItemView> getHistoryItemViewList() {
        return historyItemViewList;
    }
}