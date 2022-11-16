package com.jnu.myfirstapplication.recyclerview;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Instrumentation;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jnu.myfirstapplication.BookListFragment;
import com.jnu.myfirstapplication.BrowserFragment;
import com.jnu.myfirstapplication.CheckBoxActivity;
import com.jnu.myfirstapplication.EditBookActivity;
import com.jnu.myfirstapplication.R;
import com.jnu.myfirstapplication.data.DataSaver;

import java.util.ArrayList;

public class BookListMainActivity extends AppCompatActivity {

public class PageViewFragmentAdapter extends FragmentStateAdapter{

        public PageViewFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
                super(fragmentActivity);
        }

        public PageViewFragmentAdapter(@NonNull Fragment fragment) {
                super(fragment);
        }

        public PageViewFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
                super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
                switch(position)
                {
                        case 0:
                                return BookListFragment.newInstance();
                        case 1:
                                return BrowserFragment.newInstance();
                }
                return BookListFragment.newInstance();
        }

        @Override
        public int getItemCount() {
                return 3;
        }
}
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list_main);
        ViewPager2 viewPager2Main=findViewById(R.id.viewpage2_main);
        viewPager2Main.setAdapter(new PageViewFragmentAdapter(getSupportFragmentManager(),getLifecycle()));

        TabLayout tabLayout=findViewById(R.id.tablayout_header);
        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayout, viewPager2Main, new TabLayoutMediator.TabConfigurationStrategy() {
                @Override
                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch(position)
                        {
                                case 0:
                                        tab.setText("书架");
                                        break;
                                case 1:
                                        tab.setText("新闻");
                                        break;
                                case 2:
                                        tab.setText("卖家");
                                        break;
                        }
                }
        });
        tabLayoutMediator.attach();


        /*
        mRvMain=(RecyclerView) findViewById(R.id.recycle_view_books);
        mRvMain.setLayoutManager(new LinearLayoutManager(BookListMainActivity.this));
//        mRvMain.setAdapter(new BookListAdapter(BookListMainActivity.this));
        DataSaver dataSaver=new DataSaver();
        dataSaver.save(this,bookList);
//        bookList=dataSaver.Load(this);
//        bookList=dataSaver.Load(this);
//        for(int i=1;i<10;i++)
        if (bookList.size()==0) {
                for(int i=1;i<10;i++) {
                        bookList.add(new Book(i % 3 == 0 ? "软件项目管理案例教程（第4版）" : (i % 3 == 1 ? "创新工程实践" : "信息安全数学基础（第2版）"), i % 3 == 0 ? R.drawable.book_2 : (i % 3 == 1 ? R.drawable.book_no_name : R.drawable.book_1)));
                }
        }
        //        }
//        Book book1=new Book("软件项目管理案例教程（第4版）",R.drawable.book_2);
//        Book book2=new Book("创新工程实践",R.drawable.book_no_name);
//        Book book3=new Book("信息安全数学基础（第2版）",R.drawable.book_1);
//        bookList.add(book1);
//        bookList.add(book2);
//        bookList.add(book3);
        bookListAdapter= new BookListAdapter(bookList);
        mRvMain.setAdapter(bookListAdapter);*/
        }

}
