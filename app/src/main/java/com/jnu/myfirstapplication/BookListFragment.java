package com.jnu.myfirstapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.jnu.myfirstapplication.data.DataSaver;
import com.jnu.myfirstapplication.recyclerview.Book;
import com.jnu.myfirstapplication.recyclerview.BookListAdapter;
import com.jnu.myfirstapplication.recyclerview.BookListMainActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookListFragment extends Fragment {
    public static final int MENU_ID_ADD = 1;
    public static final int MENU_ID_UPDATE = 2;
    public static final int MENU_ID_DELETE = 3;
    private RecyclerView mRvMain;

    private ArrayList<Book> bookList=new ArrayList<>();
    private BookListAdapter bookListAdapter;


    private ActivityResultLauncher<Intent> addDataLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult()
            ,result ->{
                if(null!=result){
                    Intent intent=result.getData();
                    if(result.getResultCode()==EditBookActivity.RESULT_CODE_SUCCESS)
                    {
                        Bundle bundle=intent.getExtras();
                        String title=bundle.getString("title");
                        int position=bundle.getInt("position");
                        bookList.add(position,new Book(title,R.drawable.book_2));
                        new DataSaver().save(this.getContext(),bookList);
                        bookListAdapter.notifyItemInserted(5);
                    }
                    else
                    {

                    }

//                        bookList.add(new Book(num%3==0?"软件项目管理案例教程（第4版）":(num%3==1?"创新工程实践":"信息安全数学基础（第2版）"),num%3==0?R.drawable.book_2:(num%3==1?R.drawable.book_no_name:R.drawable.book_1)));
//                        num++;
//                        bookListAdapter.notifyItemInserted(item.getOrder());
//                        Toast.makeText(this,"input activity return",Toast.LENGTH_LONG).show();
                }
            } );
    private ActivityResultLauncher<Intent> updateDatalauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult()
            ,result ->{
                if(null!=result){
                    Intent intent=result.getData();
                    if(result.getResultCode()==EditBookActivity.RESULT_CODE_SUCCESS)
                    {
                        Bundle bundle=intent.getExtras();
                        String title=bundle.getString("title");
                        int position=bundle.getInt("position");
                        bookList.get(position).setTitle(title);
                        new DataSaver().save(this.getContext(),bookList);
                        bookListAdapter.notifyItemChanged(position);
                    }
//                        bookList.add(new Book(num%3==0?"软件项目管理案例教程（第4版）":(num%3==1?"创新工程实践":"信息安全数学基础（第2版）"),num%3==0?R.drawable.book_2:(num%3==1?R.drawable.book_no_name:R.drawable.book_1)));
//                        num++;
//                        bookListAdapter.notifyItemInserted(item.getOrder());
//                        Toast.makeText(this,"input activity return",Toast.LENGTH_LONG).show();
                }
            } );




    public BookListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment BookListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookListFragment newInstance() {
        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_book_list, container, false);

        mRvMain=rootView.findViewById(R.id.recycle_view_books);
        mRvMain.setLayoutManager(new LinearLayoutManager(BookListFragment.this.getContext()));
//        mRvMain.setAdapter(new BookListAdapter(BookListMainActivity.this));
        DataSaver dataSaver=new DataSaver();
        //dataSaver.save(this.getContext(),bookList);
        bookList=dataSaver.Load(this.getContext());
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
        mRvMain.setAdapter(bookListAdapter);

        // Inflate the layout for this fragment
        return rootView;
    }
    ////
    public int num=0;
    @Override
    public boolean onContextItemSelected(@NonNull final MenuItem item) {
        switch(item.getItemId()){
            case MENU_ID_ADD:
                Intent iintent=new Intent(BookListFragment.this.getContext(), EditBookActivity.class);
                iintent.putExtra("position",item.getOrder());
                addDataLauncher.launch(iintent);
//                                startActivity(iintent);
//                                bookList.add(new Book(num%3==0?"软件项目管理案例教程（第4版）":(num%3==1?"创新工程实践":"信息安全数学基础（第2版）"),num%3==0?R.drawable.book_2:(num%3==1?R.drawable.book_no_name:R.drawable.book_1)));
//                                num++;
//                                bookListAdapter.notifyItemInserted(item.getOrder());
                break;
            case MENU_ID_UPDATE:
                Intent intentup=new Intent(BookListFragment.this.getContext(), EditBookActivity.class);
                intentup.putExtra("position",item.getOrder());
                intentup.putExtra("title",bookList.get(item.getOrder()).getTitle());
                updateDatalauncher.launch(intentup);
//                                bookList.get(item.getOrder()).setTitle("updated 999");
//                                bookListAdapter.notifyItemChanged(item.getOrder());
                break;
            case MENU_ID_DELETE:
                AlertDialog alertDialog=new AlertDialog.Builder(this.getContext())
                        .setTitle(R.string.string_confirmation)
                        .setMessage(R.string.string_sure_to_delete)
                        .setNegativeButton(R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                bookList.remove(item.getOrder());
                                new DataSaver().save(BookListFragment.this.getContext(),bookList);
                                bookListAdapter.notifyItemRemoved(item.getOrder());
                            }
                        }).setPositiveButton(R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).create();
                alertDialog.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

}