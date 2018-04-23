package com.github.stephenvinouze.advancedrecyclerview.javasample.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.github.stephenvinouze.advancedrecyclerview.javasample.R;
import com.github.stephenvinouze.advancedrecyclerview.javasample.fragments.HistoryRecyclerFragment;
import com.github.stephenvinouze.advancedrecyclerview.javasample.models.HistoryManager;

public class HistoryActivity extends AppCompatActivity {

    /**
     * Поле HistoryManager хранит в себе список экземпляров
     * историй класса History.
     */

    private HistoryManager historyManager;

    /**
     * При создании окна истории инициализируется historyManager,
     * и мы переходим в режим упраления выбора.
     */

    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_activity);
        this.historyManager = new HistoryManager();
        this.displayGestureRecyclerFragment();
    }

    /**
     * Создание опций меню.
     */

    @Override
    public final boolean onCreateOptionsMenu(final Menu menu) {
        this.getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Событие выбора элемента меню определяет
     * режим выбора элементов.
     */

    @Override
    public final boolean onOptionsItemSelected(final MenuItem item) {
        this.displayGestureRecyclerFragment();
        return super.onOptionsItemSelected(item);
    }

    /**
     * Режим перетаскивания и удаленя элементов.
     */

    private void displayGestureRecyclerFragment() {
        final Fragment fragment = new HistoryRecyclerFragment(historyManager);
        this.setTitle(getString(R.string.gesture_recycler_name));
        this.getSupportFragmentManager().beginTransaction().replace(R.id.main_container
                , fragment).commit();
    }
}
