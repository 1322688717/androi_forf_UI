package com.example.androidui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityDataStructureBinding;

public class DataStructureActivity extends AppCompatActivity {

    ActivityDataStructureBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataStructureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        intitView();
    }


    private void intitView() {
        binding.btnMindMapping.setOnClickListener(view ->btnMindMapping() );
        binding.btnArray.setOnClickListener(view ->btnArray() );
        binding.btnStack.setOnClickListener(view -> btnStack());
        binding.btnQueue.setOnClickListener(view -> btnQueue());
        binding.btnList.setOnClickListener(view -> btnList());
        binding.btnTree.setOnClickListener(view -> btnTree());
        binding.btnFigure.setOnClickListener(view ->btnFigure());
        binding.btnHeap.setOnClickListener(view -> btnHeap());
    }

    /**
     * 堆
     */
    private void btnHeap() {

    }

    /**
     * 图
     */
    private void btnFigure() {

    }

    /**
     * 树
     */
    private void btnTree() {
        binding.tvContent.setText("①概念\n" +
                "由一个根节点和若干个子树构成的集合。\n" +
                "\n" +
                "②特点\n" +
                "\n" +
                "有且仅有一个根节点；\n" +
                "\n" +
                "子树之间不可以有交集；\n" +
                "\n" +
                "树分为无序树，有序树，二叉树等；\n" +
                "\n" +
                "树的深度指的是树的有多少层；\n" +
                "\n" +
                "一个节点的度指的是该节点下有多少个子节点；\n" +
                "\n" +
                "二叉树指的是每个结点的度≤2的树。\n" +
                "\n" +
                "树的遍历方式分为三种，分别是前序遍历（根左右），中序遍历（左根右），后序遍历（左右根）；\n");
        binding.imgPicture.setImageResource(R.drawable.tree);
    }

    /**
     * 链表
     */
    private void btnList() {
        binding.tvContent.setText("①概念\n" +
                "一种非连续，非顺序的存储方式，通过指针将数据进行连接的方式实现。\n" +
                "\n" +
                "②特点\n" +
                "\n" +
                "在创建的时候，不需要指定长度，可以动态调整长度，不易产生碎片；\n" +
                "\n" +
                "链表的每个元素分为数据和指针，指针指向下一个数据的地址，从而形成串联；\n" +
                "\n" +
                "便于数据增删，不便于数据查询；\n" +
                "\n" +
                "链表分为单向链表，双向链表，循环列表；\n" +
                "————————————————\n" +
                "版权声明：本文为CSDN博主「恬静释然」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。\n" +
                "原文链接：https://blog.csdn.net/qq_41648631/article/details/103183533");
        binding.imgPicture.setImageResource(R.drawable.list);

    }


    private void btnQueue() {
        binding.tvContent.setVisibility(View.VISIBLE);
        binding.tvContent.setText("在创建的时候，不需要指定长度，可以动态调整长度，不易产生碎片；\n" +
                "\n" +
                "链表的每个元素分为数据和指针，指针指向下一个数据的地址，从而形成串联；\n" +
                "\n" +
                "便于数据增删，不便于数据查询；\n" +
                "\n" +
                "链表分为单向链表，双向链表，循环列表；");
        binding.imgPicture.setImageResource(R.drawable.queue);
    }


    private void btnStack() {
        binding.tvContent.setVisibility(View.VISIBLE);
        binding.tvContent.setText("按照先进后出的原则存储数据；\n" +
                "\n" +
                "栈分为顺序栈和链式栈；");
        binding.imgPicture.setImageResource(R.drawable.stack);
    }

    /**
     * 数组
     */
    private void btnArray() {
        binding.tvContent.setVisibility(View.VISIBLE);
        binding.tvContent.setText("数组中的数据元素可以是基本数据类型，也可以是引用数据类型；\n" +
                "\n" +
                "数组具有下标，下标从0开始计数，用于快速获取数组中的数据，比如a[0]，表示数组中的第一个数据；\n" +
                "\n" +
                "数组在创建的时候，需要在内存中申请一段固定长度的内存，如果申请的长度超过内存剩余的长度，则容易产生碎片，导致存储失败；\n" +
                "\n" +
                "数组便于查找和修改数据，不便于增删数据；\n" +
                "\n" +
                "数组分为数值数组，字符数组，指针数组，结构数组等；\n");

        binding.imgPicture.setImageResource(R.drawable.array);
    }

    private void btnMindMapping() {
        binding.imgPicture.setVisibility(View.VISIBLE);
        binding.tvContent.setVisibility(View.GONE);
        binding.imgPicture.setImageResource(R.drawable.datastrcture);
    }
}