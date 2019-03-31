package com.sasakisan.android_custom_view_sample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CanvasView : View {

    private val pathList = mutableListOf<Path>()

    private val paint = Paint()

    private var drawingPath: Path? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    private fun init() {
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        paint.strokeWidth = 10F
    }


    override fun onDraw(canvas: Canvas?) {
        pathList.forEach { path ->
            canvas?.let {
                canvas.drawPath(path, paint)
            }
        }
        invalidate()
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    drawingPath = Path()
                    drawingPath?.let {
                        it.moveTo(event.x, event.y)
                        pathList.add(it)
                    }
                }
                MotionEvent.ACTION_UP -> {
                    drawingPath?.moveTo(event.x, event.y)
                    performClick()
                }
                MotionEvent.ACTION_MOVE -> {
                    drawingPath?.lineTo(event.x, event.y)
                }
                else -> {
                }
            }
        }
        return true
    }

    fun deleteAll() {
        pathList.clear()
    }
}