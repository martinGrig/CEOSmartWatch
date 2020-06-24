package com.example.smartwatchapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import kotlinx.android.synthetic.main.activity_finance.*

class FinanceActivity : WearableActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finance)

        val colorPal = mutableListOf(
            Color.parseColor("#00AFD4"),
            Color.parseColor("#F0524F"),
            Color.parseColor("#F07D00")
        )

        patientsChart.setUsePercentValues(true)
        patientsChart.description.isEnabled = false;
        patientsChart.setNoDataText("No Expenses Found")
        patientsChart.setExtraOffsets(5F, 5F, 5F, 5F)

        patientsChart.setDrawEntryLabels(true)

        patientsChart.setDrawMarkers(true)
        patientsChart.isHighlightPerTapEnabled = true
        patientsChart.legend.isEnabled = true
        patientsChart.legend.horizontalAlignment
        patientsChart.legend.textSize = 12f
        patientsChart.legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        patientsChart.legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        patientsChart.legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        patientsChart.legend.setDrawInside(false);
        patientsChart.legend.form = Legend.LegendForm.CIRCLE
        patientsChart.legend.formSize = 10f
        patientsChart.legend.setXEntrySpace(5f)
        patientsChart.legend.xOffset = -5f
        patientsChart.legend.yOffset = 10f
        patientsChart.dragDecelerationFrictionCoef = 0.95F
        patientsChart.animateY(1000, Easing.EaseInOutCubic)

        patientsChart.isDrawHoleEnabled = true
        patientsChart.setHoleColor(Color.TRANSPARENT)
        patientsChart.holeRadius = 60F
        patientsChart.transparentCircleRadius = 20F
        patientsChart.setDrawCenterText(true)

        val yValues = mutableListOf<PieEntry>()
        //Add values to the pie chart
        var financeCosts: Float = 900f
        var financeIncome: Float = 300f
        var financeInsurance: Float = 700f
        yValues.add(PieEntry(financeCosts, "Expenses"))
        yValues.add(PieEntry(financeIncome, "Profit"))
        yValues.add(PieEntry(financeInsurance, "Insurance"))

        val dataSet = PieDataSet(yValues, "")
        dataSet.valueFormatter = PercentFormatter(patientsChart)
        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 5f

        dataSet.colors = colorPal

        val data = PieData(dataSet)
        data.setValueTextSize(12f)
        data.setValueTextColor(Color.WHITE)
        patientsChart.setDrawSliceText(false)
        patientsChart.setUsePercentValues(true)

        patientsChart.data = data

    }
}