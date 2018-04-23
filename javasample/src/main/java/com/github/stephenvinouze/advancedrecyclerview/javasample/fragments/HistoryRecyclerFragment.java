package com.github.stephenvinouze.advancedrecyclerview.javasample.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.stephenvinouze.advancedrecyclerview.core.enums.ChoiceMode;
import com.github.stephenvinouze.advancedrecyclerview.gesture.extensions.GestureKt;
import com.github.stephenvinouze.advancedrecyclerview.javasample.R;
import com.github.stephenvinouze.advancedrecyclerview.javasample.adapters.HistoryAdapter;
import com.github.stephenvinouze.advancedrecyclerview.javasample.fragments.mode.RecyclerFragmentMode;
import com.github.stephenvinouze.advancedrecyclerview.javasample.models.History;
import com.github.stephenvinouze.advancedrecyclerview.javasample.models.HistoryManager;

import static com.github.stephenvinouze.advancedrecyclerview.javasample.fragments.mode.RecyclerFragmentMode.EDITING;
import static com.github.stephenvinouze.advancedrecyclerview.javasample.fragments.mode.RecyclerFragmentMode.WATCHING;

/**
 * Класс HistoryRecyclerFragment является фрагментом окна историй.
 * Хранит в себе различные режимы перерключения, а также обрабатывает
 * события при взаимодействии с пользователем.
 */

@SuppressLint("ValidFragment")
public final class HistoryRecyclerFragment extends Fragment {

    /**
     * RecycleView хранит в себе динамический меассив объектов View.
     */

    private RecyclerView recyclerView;

    /**
     * HistoryManager отвечает за подгрузку историй History в HistoryAdapter.
     */

    private final HistoryManager historyManager;

    /**
     * HistoryAdapter обрабатывает события.
     */

    private HistoryAdapter adapter;

    /**
     * RecyclerFragmentMode указывает пользовательский режим History фрагмента.
     * RecyclerFragmentMode.WATCHING - режим просмотра и открытие истории;
     * RecyclerFragmentMode.EDITING - режим редактирования историй.
     */

    private RecyclerFragmentMode recyclerFragmentMode;

    /**
     * Конструктор:
     * @param historyManager
     * хранит в себе истории - экземпляры класса History в виде списка
     */

    @SuppressLint("ValidFragment")
    public HistoryRecyclerFragment(final HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    /**
     * onCreateView() - стандартный метод, инициализирующий View из XML файла
     */

    @Nullable
    @Override
    public final View onCreateView(final @NonNull LayoutInflater inflater
            , final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_layout, container, false);
    }

    /**
     * В методе onViewCreated() происходит настройка RecyclerView,
     * устанавливается режим просмотра историй, инициализируется и
     * устанавливается в RecycleView адаптер, активируется обработка
     * жестикуляции.
     */

    @Override
    public final void onViewCreated(final @NonNull View view
            , final @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.configureRecyclerView(view.findViewById(R.id.recycler_view));
        this.recyclerFragmentMode = WATCHING;
        this.adapter = this.createAdapter();
        this.recyclerView.setAdapter(adapter);
        this.setEnableGestures();
    }

    /**
     * configureRecyclerView(final RecyclerView recyclerView) -
     * - настраивает RecycleView.
     * @param recyclerView, который нужно настроить
     */

    private void configureRecyclerView(final RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * createAdapter()
     * @return обработчик событий истории.
     */

    private HistoryAdapter createAdapter() {
        final HistoryAdapter adapter = new HistoryAdapter(getContext());
        adapter.setItems(historyManager.mockItems());
        adapter.setChoiceMode(ChoiceMode.NONE);
        adapter.setOnLongClick((view, position) -> {
            switch (recyclerFragmentMode) {
                case WATCHING:
                    //Переключились в режим редактирования:
                    adapter.setChoiceMode(ChoiceMode.MULTIPLE);
                    //Поставили галочку руками:
                    adapter.getSparseBooleanArray().put(position, true);
                    final History history = adapter.getItems().get(position);
                    this.showToast(history);
                    this.recyclerFragmentMode = EDITING;
                    break;
                case EDITING:
                    this.recyclerFragmentMode = WATCHING;
            }
            return true;
        });
        adapter.setOnClick((view, position) -> {
            System.out.println("GO TO HISTORY");
            return null;
        });
        return adapter;
    }

    private void setEnableGestures(){
        GestureKt.enableGestures(this.recyclerView
                , ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT
                , null
        );
    }

    private void showToast(final History history){
        Toast.makeText(getActivity(), this.createText(history), Toast.LENGTH_SHORT).show();
    }

    private String createText(final History history) {
        return "Выбрана история : " + history.getId() + " (" + adapter.getSelectedItemViewCount()
                + " выбрано)";
    }
}