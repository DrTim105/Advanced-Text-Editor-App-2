package com.salihutimothy.advancedtexteditor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chinalwb.are.render.AreTextView


/**
 * @author dlink
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2018/5/21
 * @discription null
 * @usage null
 */
class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)
        val areTextView = findViewById<AreTextView>(R.id.areTextView)
        var s = intent.getStringExtra(HTML_TEXT)
        if (null == s) {
            s = """<html><body><p><b>aaaa</b></p><p><i>bbbb</i></p>
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
    <p style="text-align:center;"><img src="emoji|2131230945"></p>
    <p style="text-align:start;">Image:</p>
    <p style="text-align:start;"><img src="http://d.hiphotos.baidu.com/image/pic/item/6159252dd42a2834171827b357b5c9ea14cebfcf.jpg"></p>
    <p style="text-align:start;"></p>
    </body></html>"""
        }
        areTextView.fromHtml(s)
    }

    companion object {
        const val HTML_TEXT = "html_text"
    }
}