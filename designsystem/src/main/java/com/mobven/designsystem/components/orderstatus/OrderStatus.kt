package com.mobven.designsystem.components.orderstatus

import androidx.annotation.DrawableRes
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mobven.components.R
import com.mobven.designsystem.components.bottomnavbar.ItemIconNavBar
import com.mobven.designsystem.components.bottomnavbar.YummyBottomNavBar
import com.mobven.designsystem.components.common.CardOne
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.theme.AdditionalDark
import com.mobven.designsystem.theme.MainPrimary
import com.mobven.designsystem.theme.NeutralGrayscale10
import com.mobven.designsystem.theme.NeutralGrayscale80
import com.mobven.designsystem.theme.h2SemiBoldStyle
import com.mobven.designsystem.theme.h3BoldStyle
import com.mobven.designsystem.theme.h3NormalStyle
import com.mobven.designsystem.theme.h4SemiBoldStyle
import com.mobven.designsystem.theme.h5MediumStyle
import com.mobven.designsystem.theme.h5SemiBoldStyle

@Composable
fun OrderStatus(
    modifier: Modifier = Modifier,
    currentStep: CurrentStep = CurrentStep.BEING_DELIVEREING
) {
    val list = listOf<OrderStatusModel>(
        OrderStatusModel(step = 1, R.drawable.ic_receipt_unselected),
        OrderStatusModel(step = 2, R.drawable.ic_stage_circles_unselected),
        OrderStatusModel(step = 3, R.drawable.ic_soup),
        OrderStatusModel(step = 4, R.drawable.ic_stage_circles_unselected),
        OrderStatusModel(step = 5, R.drawable.ic_man),
        OrderStatusModel(step = 6, R.drawable.ic_stage_circles_unselected),
        OrderStatusModel(step = 7, R.drawable.ic_check_circle)
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 20.dp,
                spotColor = AdditionalDark,
                ambientColor = AdditionalDark
            )
            .background(color = NeutralGrayscale10)
    ) {
        Text(
            text = "Status",
            style = MaterialTheme.typography.h2SemiBoldStyle,
            modifier = modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp)
        )
        VerticalSpacer(height = 15.dp)
        Text(
            text = currentStep.statusText,
            style = MaterialTheme.typography.h5MediumStyle,
            modifier = modifier.padding(horizontal = 24.dp)
        )
        VerticalSpacer(height = 15.dp)
        LazyRow(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            items(list) {
                if (it.step <= currentStep.type) {
                    ItemOrderStatus(icon = it.icon, isSelected = true)
                } else {
                    ItemOrderStatus(icon = it.icon, isSelected = false)
                }
            }

        }
        TextButton(onClick = { /*TODO*/ },  modifier= Modifier.padding(horizontal = 15.dp)) {
            Row {
                Text(text = "Follow the order", color = AdditionalDark, style = MaterialTheme.typography.h4SemiBoldStyle)
                YummyIcon(painterRes = R.drawable.ic_arrow_order, tint = AdditionalDark, modifier = Modifier.padding(top = 3.3.dp, start = 7.dp))
            }
        }
    }

}


@Composable
fun ItemOrderStatus(
    @DrawableRes icon: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Crossfade(targetState = isSelected, label = "") { isSelected ->
            ItemIconStatus(
                isSelected = isSelected,
                icon = icon,
            )
        }
    }

}

enum class CurrentStep(val type: Int, val statusText: String) {
    ORDER(1, "Your order is being notified to the restaurant"),
    PREPEARING(3, "Your order is being prepared"),
    BEING_DELIVEREING(5, "Your order is being delivered"),
    SUCCESSFULLY_DELIVERED(7, "Your order has been successfully delivered")
}

@Composable
fun ItemIconStatus(
    isSelected: Boolean,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    YummyIcon(
        painterRes = if (isSelected) icon else icon,
        tint = if (isSelected) MainPrimary else NeutralGrayscale80
    )
}

@Preview
@Composable
fun OrderStatusPreview() {
    OrderStatus()
}