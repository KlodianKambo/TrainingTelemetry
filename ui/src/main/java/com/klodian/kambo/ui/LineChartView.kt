package com.klodian.kambo.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class LineChartView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    // Define the Paint objects for drawing the chart
    private val linePaint = Paint().apply {
        color = Color.RED
        strokeWidth = 5f
        style = Paint.Style.FILL_AND_STROKE
    }
    private val axisPaint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 2f
        style = Paint.Style.STROKE
    }

    // Define the x and y values for the chart
    private var xValues = floatArrayOf()
    private var yValues = floatArrayOf()

    // Define the scaling factors for the x and y axes
    private var xScale = 0f
    private var yScale = 0f

    init {
        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Set up the chart dimensions and position
        val margin = 8
        val chartWidth = width - margin * 2
        val chartHeight = 500

        val chartLeft = margin
        val chartTop = margin
        val chartRight = chartLeft + chartWidth
        val chartBottom = chartTop + chartHeight

        // Calculate the min and max values for the x and y axes
        val xMin = xValues.minOrNull() ?: 0f
        val xMax = xValues.maxOrNull() ?: 0f
        val yMin = yValues.minOrNull() ?: 0f
        val yMax = yValues.maxOrNull() ?: 0f

        // Define the scaling factors for the x and y axes
        xScale = chartWidth / ((xMax - xMin).takeIf { it >0 } ?: 1f)
        yScale = chartHeight / ((yMax - yMin).takeIf { it >0 } ?: 1f)

        // Draw the x and y axes
        canvas?.drawLine(chartLeft.toFloat(), chartTop.toFloat(), chartLeft.toFloat(), chartBottom.toFloat(), axisPaint)
        canvas?.drawLine(chartLeft.toFloat(), chartBottom.toFloat(), chartRight.toFloat(), chartBottom.toFloat(), axisPaint)

        // Draw the data points and lines
        for (i in 0 until xValues.size) {
            val x = chartLeft + (xValues[i] - xMin) * xScale
            val y = chartBottom - (yValues[i] - yMin) * yScale
            if (i == 0) {
                canvas?.drawPoint(x, y, linePaint)
            } else {
                val prevX = chartLeft + (xValues[i-1] - xMin) * xScale
                val prevY = chartBottom - (yValues[i-1] - yMin) * yScale
                canvas?.drawLine(prevX, prevY, x, y, linePaint)
                canvas?.drawPoint(x, y, linePaint)
            }
        }
    }

    fun addValue(y: Float) {
        // Add a new value to the chart data
        xValues = xValues.plus(xValues.size + 1f)
        yValues = yValues.plus(y)

        // Invalidate the view to trigger a redraw
        invalidate()
    }
}