package com.salihutimothy.advancedtexteditor


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ViewTreeObserver.OnScrollChangedListener
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.chinalwb.are.AREditText
import com.chinalwb.are.AREditor
import com.salihutimothy.advancedtexteditor.TextViewActivity.Companion.HTML_TEXT
import com.chinalwb.are.models.AtItem
import com.chinalwb.are.strategies.AtStrategy
import com.chinalwb.are.strategies.VideoStrategy
import com.chinalwb.are.styles.toolbar.ARE_Toolbar
import com.chinalwb.are.styles.toolbar.ARE_ToolbarDefault
import com.chinalwb.are.styles.toolbar.IARE_Toolbar
import com.chinalwb.are.styles.toolitems.*
import java.lang.Exception


/**
 * All Rights Reserved.
 *
 * @author Wenbin Liu
 */
class MainActivity : AppCompatActivity() {
    private lateinit var arEditor: AREditor
    private lateinit var mToolbar: IARE_Toolbar
    private lateinit var mEditText: AREditText
    private var scrollerAtEnd = false
    private val mAtStrategy: AtStrategy = object : AtStrategy {

        override fun openAtPage() {
//            val intent = Intent(this@MainActivity, AtActivity::class.java)
//            startActivityForResult(intent, ARE_Toolbar.REQ_AT)
        }

        override fun onItemSelected(item: AtItem): Boolean {
            return false
        }
    }
    private val mVideoStrategy: VideoStrategy = object : VideoStrategy {
        override fun uploadVideo(uri: Uri): String {
            try {
                Thread.sleep(3000) // Do upload here
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return "http://www.xx.com/x.mp4"
        }

        override fun uploadVideo(videoPath: String): String {
            try {
                Thread.sleep(3000)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return "http://www.xx.com/x.mp4"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        if (useOption1) {
            option1()
        } else {
            option2()
        }
        val html = """<html><body><p><b>aaaa</b></p><p><i>bbbb</i></p>
    <p><u>cccc</u></p>
    <p><span style="text-decoration:line-through;">dddd</span></p>
    <p style="text-align:start;">Alignleft</p>
    <p style="text-align:center;">Align center</p>
    <p style="text-align:end;">Align right</p>
    <p style="text-align:start;">Align left</p>
    <p style="text-align:start;">Hello left<span style="background-color:#FFFF00;"> good?</span> yes</p>
    <p style="text-align:start;">Text color <span style="color:#FF5722;">red </span><span style="color:#4CAF50;">green </span><span style="color:#2196F3;">blue </span><span style="color:#9C27B0;">purple</span><span style="color:#000000;"> normal black</span></p>
    <br>
    <p style="text-align:start;">Click to open <a href="http://www.qq.com">QQ</a> website</p>
    <br><br>
    <blockquote><p style="text-align:start;">Quote</p>
    <p style="text-align:start;">Quote 2nd line</p>
    <br>
    </blockquote>
    <br><br>
    <p style="text-align:start;">2X<sub>1</sub><sup>2 </sup>+3X<sub>1</sub><sup>2</sup>=5X<sub>1</sub><sup>2</sup></p>
    <br>
    <br>
    <p style="text-align:start;"><hr /> </p>
    <p style="text-align:start;">Text <span style="font-size:32px";>SIZE </span><span style="font-size:18px";><span style="font-size:21px";>normal</span></span></p>
    <br>
    <p style="text-align:center;"><img src="emoji|${R.drawable.wx_d_8}"></p>
    <p style="text-align:start;">Image:</p>
    <p style="text-align:start;"><img src="http://d.hiphotos.baidu.com/image/pic/item/6159252dd42a2834171827b357b5c9ea14cebfcf.jpg" /></p>
    <p style="text-align:start;"></p>
    <p><a href="#" ukey="2131230814" uname="Steve Jobs" style="color:#FF00FF;">@Steve Jobs</a>, <a href="#" ukey="2131230815" uname="Bill Gates" style="color:#0000FF;">@Bill Gates</a>, how are you?</p>    <p style="text-align:start;"><emoji src="2131230915" /><emoji src="2131230936" /><emoji src="2131230929" /></p>    <ul>    <li>aa</li>    <li>bb</li>
    <li>dd</li>
    <li>eea</li>
    </ul>    <ol>
    <li>ddasdf</li>
    <li>sdf</li>
    <li>cc</li>
    </ol>    <p style="text-align:center;"><video src="http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8" controls="controls"></video></p>    <p style="text-align:start;"><img src="http://a.hiphotos.baidu.com/image/h%3D300/sign=13dc7fee3512b31bd86ccb29b6193674/730e0cf3d7ca7bcb6a172486b2096b63f624a82f.jpg" /></p>    </body></html>"""
        arEditor = findViewById(R.id.areditor)

        if (useOption1) {
            // mEditText.fromHtml(html);
        } else {
//            arEditor.fromHtml(html)
        }
    }

    private fun option2() {
        arEditor = findViewById(R.id.areditor)
        //        this.arEditor.setHideToolbar(false);
//        this.arEditor.setExpandMode(AREditor.ExpandMode.FULL);
//        this.arEditor.setToolbarAlignment(AREditor.ToolbarAlignment.BOTTOM);
        arEditor.setAtStrategy(mAtStrategy)
        arEditor.setVideoStrategy(mVideoStrategy)
    }

    private fun option1() {
        mToolbar = findViewById(R.id.areToolbar)
        val bold: IARE_ToolItem = ARE_ToolItem_Bold()
        val italic: IARE_ToolItem = ARE_ToolItem_Italic()
        val underline: IARE_ToolItem = ARE_ToolItem_Underline()
        val strikethrough: IARE_ToolItem = ARE_ToolItem_Strikethrough()
        val quote: IARE_ToolItem = ARE_ToolItem_Quote()
        val fontColor : IARE_ToolItem = ARE_ToolItem_FontColor()
        val listNumber: IARE_ToolItem = ARE_ToolItem_ListNumber()
        val listBullet: IARE_ToolItem = ARE_ToolItem_ListBullet()
        val hr: IARE_ToolItem = ARE_ToolItem_Hr()
        val link: IARE_ToolItem = ARE_ToolItem_Link()
        val subscript: IARE_ToolItem = ARE_ToolItem_Subscript()
        val superscript: IARE_ToolItem = ARE_ToolItem_Superscript()
        val left: IARE_ToolItem = ARE_ToolItem_AlignmentLeft()
        val center: IARE_ToolItem = ARE_ToolItem_AlignmentCenter()
        val right: IARE_ToolItem = ARE_ToolItem_AlignmentRight()
        val image: IARE_ToolItem = ARE_ToolItem_Image()
        val video: IARE_ToolItem = ARE_ToolItem_Video()
        val at: IARE_ToolItem = ARE_ToolItem_At()
        mToolbar.addToolbarItem(bold)
        mToolbar.addToolbarItem(italic)
        mToolbar.addToolbarItem(underline)
        mToolbar.addToolbarItem(strikethrough)
        mToolbar.addToolbarItem(quote)
        mToolbar.addToolbarItem(fontColor)
        mToolbar.addToolbarItem(listNumber)
        mToolbar.addToolbarItem(listBullet)
        mToolbar.addToolbarItem(hr)
        mToolbar.addToolbarItem(link)
        mToolbar.addToolbarItem(subscript)
        mToolbar.addToolbarItem(superscript)
        mToolbar.addToolbarItem(left)
        mToolbar.addToolbarItem(center)
        mToolbar.addToolbarItem(right)
        mToolbar.addToolbarItem(image)
        mToolbar.addToolbarItem(video)
//        mToolbar.addToolbarItem(at)
        mEditText = findViewById(R.id.yView)
        mEditText.setToolbar(mToolbar)
        initToolbarArrow()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(com.chinalwb.are.R.menu.main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val menuId = item.itemId
//        if (menuId == com.chinalwb.are.R.id.action_save) {
//            if (useOption1) {
//                val html = mEditText!!.html
//                DemoUtil.saveHtml(this, html)
//            } else {
//                val html = arEditor!!.html
//                DemoUtil.saveHtml(this, html)
//            }
//            return true
//        }
//        if (menuId == R.id.action_show_tv) {
//            var html: String? = ""
//            html = if (useOption1) {
//                mEditText!!.html
//            } else {
//                arEditor!!.html
//            }
//            val intent = Intent(this, TextViewActivity::class.java)
//            intent.putExtra(HTML_TEXT, html)
//            startActivity(intent)
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }

    private fun initToolbarArrow() {
        val imageView = findViewById<ImageView>(R.id.arrow)
        mToolbar = findViewById(R.id.areToolbar)

        if (mToolbar is ARE_ToolbarDefault) {
            (mToolbar as ARE_ToolbarDefault).viewTreeObserver.addOnScrollChangedListener {
                val scrollX = (mToolbar as ARE_ToolbarDefault).scrollX
                val scrollWidth = (mToolbar as ARE_ToolbarDefault).width
                val fullWidth = (mToolbar as ARE_ToolbarDefault).getChildAt(0).width
                scrollerAtEnd = if (scrollX + scrollWidth < fullWidth) {
                    imageView.setImageResource(R.drawable.arrow_right)
                    false
                } else {
                    imageView.setImageResource(R.drawable.arrow_left)
                    true
                }
            }
        }
        imageView.setOnClickListener {
            scrollerAtEnd = if (scrollerAtEnd) {
                (mToolbar as ARE_ToolbarDefault?)!!.smoothScrollBy(
                    -Int.MAX_VALUE,
                    0
                )
                false
            } else {
                val hsWidth = (mToolbar as ARE_ToolbarDefault?)!!.getChildAt(0).width
                (mToolbar as ARE_ToolbarDefault?)!!.smoothScrollBy(hsWidth, 0)
                true
            }
        }
    }

    /**
     * The layout file.
     */
    private val layoutId: Int
        get() = R.layout.activity_main

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mToolbar = findViewById(R.id.areToolbar)

        if (requestCode == REQ_WRITE_EXTERNAL_STORAGE) {
            val html = arEditor.html
            DemoUtil.saveHtml(this, html)
            return
        }
        if (useOption1) {
            mToolbar.onActivityResult(requestCode, resultCode, data)
        } else {
            arEditor.onActivityResult(requestCode, resultCode, data)
        }
    }

    companion object {
        private const val useOption1 = true
        private const val REQ_WRITE_EXTERNAL_STORAGE = 10000
    }
}