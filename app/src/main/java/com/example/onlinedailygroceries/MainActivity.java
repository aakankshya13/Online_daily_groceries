package com.example.onlinedailygroceries;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinedailygroceries.adapter.CategoryAdapter;
import com.example.onlinedailygroceries.adapter.DiscountedProductAdapter;
import com.example.onlinedailygroceries.adapter.RecentlyViewedAdapter;
import com.example.onlinedailygroceries.model.Category;
import com.example.onlinedailygroceries.model.DiscountedProducts;
import com.example.onlinedailygroceries.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView discountedRecyclerView,categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    CategoryAdapter categoryAdapter;
    RecentlyViewedAdapter recentlyViewedAdapter;
    List<DiscountedProducts> discountedProductslist;
    List<Category> categoryList;
    List<RecentlyViewed> recentlyViewedList;
    ImageView allCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //adding data to model
        discountedRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AllCategory.class);
                startActivity(i);
            }
        });

        discountedProductslist = new ArrayList<>();
        discountedProductslist.add(new DiscountedProducts( 1, R.drawable.discountberry));
        discountedProductslist.add(new DiscountedProducts(2, R.drawable.discountbrocoli));
        discountedProductslist.add(new DiscountedProducts(3, R.drawable.discountmeat));
        discountedProductslist.add(new DiscountedProducts( 4, R.drawable.discountberry));
        discountedProductslist.add(new DiscountedProducts(5, R.drawable.discountbrocoli));
        discountedProductslist.add(new DiscountedProducts(6, R.drawable.discountmeat));

        categoryList = new ArrayList<>();
        categoryList.add(new Category( 1, R.drawable.ic_home_fish));
        categoryList.add(new Category( 2, R.drawable.home_dairy));
        categoryList.add(new Category( 3, R.drawable.home_dessert));
        categoryList.add(new Category( 4, R.drawable.home_drink));
        categoryList.add(new Category( 5, R.drawable.home_egg));
        categoryList.add(new Category( 6, R.drawable.home_fruits));
        categoryList.add(new Category( 7, R.drawable.home_meat));
        categoryList.add(new Category( 8, R.drawable.home_spices));


        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Watermelon","Watermelon has high water content and also provides some fiber","₹ 80","2","KG",R.drawable.card4, R.drawable.b4));
        recentlyViewedList.add(new RecentlyViewed("Papaya", "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.", "₹ 85", "1", "KG",R.drawable.card3, R.drawable.b3));
        recentlyViewedList.add(new RecentlyViewed("Strawberry", "The strawberry is a highly nutritious fruit, loaded with vitamin C.", "₹ 30", "1", "KG", R.drawable.card2, R.drawable.b1));
        recentlyViewedList.add(new RecentlyViewed("Kiwi", "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.", "₹ 30", "1", "PC", R.drawable.card1, R.drawable.b2));

        setDiscountedRecycler(discountedProductslist);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);
    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountedRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this,dataList);
        discountedRecyclerView.setAdapter(discountedProductAdapter);
    }
    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }
    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedList) {
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}