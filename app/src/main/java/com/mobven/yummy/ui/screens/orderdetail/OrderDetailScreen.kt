package com.mobven.yummy.ui.screens.orderdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobven.components.R
import com.mobven.designsystem.components.buttons.YummyButton
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.components.common.YummyImage
import com.mobven.designsystem.components.orderstatus.CurrentStep
import com.mobven.designsystem.components.orderstatus.OrderStatus
import com.mobven.designsystem.components.toolbar.YummyToolbar
import com.mobven.designsystem.theme.additionalDark
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h2BoldStyle
import com.mobven.designsystem.theme.h3SemiBoldStyle
import com.mobven.designsystem.theme.h4BoldStyle
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.h5SemiBoldStyle
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.neutralGrayscale100
import com.mobven.designsystem.theme.neutralGrayscale30
import com.mobven.designsystem.theme.neutralGrayscale50
import com.mobven.designsystem.theme.neutralGrayscale60
import com.mobven.designsystem.theme.neutralGrayscale80
import com.mobven.designsystem.theme.neutralGrayscale90
import com.mobven.designsystem.theme.sfProFamily
import com.mobven.designsystem.theme.smallSemiBoldStyle
import com.mobven.designsystem.util.yummyPadding
import com.mobven.yummy.ui.screens.option.OptionScreen

val list = listOf(
    OrderList(
        foodImage = R.drawable.img_waffle,
        number = 2,
        price = "$7.02",
        foodName = "Croissants",
        note = "happy not angry"
    ),
    OrderList(
        foodImage = R.drawable.img_fish,
        number = 2,
        price = "$7.02",
        foodName = "Croissants",
        note = "happy not angry"
    ),
    OrderList(
        foodImage = R.drawable.img_salad,
        number = 2,
        price = "$7.02",
        foodName = "Croissants",
        note = "happy not angry"
    )
)

val serviceList = listOf(
    ServiceModel(
        service = "Quantity  (4 items)",
        price = 300.000
    ),
    ServiceModel(
        service = "Shipping fee : 1,5 km",
        price = 9.000
    ),
    ServiceModel(
        service = "Voucher",
        price = -50.000
    ),
    ServiceModel(
        service = "Yummy",
        price = -9.000
    )
)

val orderInfoDetail = listOf(
    OrderInfoDetailModel(
        title = "Order code",
        detail = "DBAJFI-55616_SD34V"
    ),
    OrderInfoDetailModel(
        title = "Receiver",
        detail = "Dinh Bao"
    ),
    OrderInfoDetailModel(
        title = "Phone number",
        detail = "0356056591"
    ),
    OrderInfoDetailModel(
        title = "Address",
        detail = "89 Pham Van Đong, Mai Dich, Cau Giay, Ha Noi, Viet Nam"
    )
)

@Composable
fun OrderDetailScreen() {

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.additionalWhite)
    ) {
        item {
            OrderStatus(currentStep = CurrentStep.ORDER, modifier = Modifier.padding(bottom = 8.dp))

            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .wrapContentHeight()
            ) {
                list.forEach {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BoxWithConstraints(
                            modifier = Modifier
                                .padding(start = 38.5.dp, bottom = 4.dp)
                        ) {
                            YummyImage(
                                imgResId = it.foodImage,
                                modifier = Modifier
                                    .width(56.dp)
                                    .height(56.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .size(24.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.additionalWhite,
                                        shape = CircleShape
                                    )
                            ) {
                                Text(
                                    text = "x2",
                                    style = MaterialTheme.typography.smallSemiBoldStyle,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight()
                                        .align(Alignment.Center)
                                        .padding(start = 5.dp, top = 4.5.dp)
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .padding(start = 12.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = it.foodName,
                                style = MaterialTheme.typography.h4BoldStyle,
                                modifier = Modifier.padding(top = 5.dp)
                            )
                            VerticalSpacer(height = 4.dp)
                            Text(text = it.note)
                        }
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(end = 38.5.dp),
                            text = it.price,
                            style = MaterialTheme.typography.h4BoldStyle,
                            color = MaterialTheme.colorScheme.neutralGrayscale80,
                        )
                    }
                    Divider(
                        color = MaterialTheme.colorScheme.neutralGrayscale50,
                        thickness = 1.dp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            ) {
                serviceList.forEach {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = it.service,
                            style = MaterialTheme.typography.h4MediumStyle,
                            modifier = Modifier.padding(top = 12.dp, start = 24.dp)
                        )
                        var color = MaterialTheme.colorScheme.additionalDark
                        if (it.price < 0) {
                            color = MaterialTheme.colorScheme.mainPrimary
                        }
                        Text(
                            text = String.format("%.3f", it.price).replace(',', '.') + "đ",
                            style = MaterialTheme.typography.h4MediumStyle,
                            modifier = Modifier.padding(top = 12.dp, end = 24.dp),
                            color = color
                        )
                    }
                }
            }
            var totalPayment = 0.0
            var nonDiscounted = 0.0
            serviceList.forEach {
                if (it.price > 0) {
                    nonDiscounted += it.price
                }
                totalPayment += it.price
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total payment",
                    style = MaterialTheme.typography.h4BoldStyle,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = String.format("%.3f", nonDiscounted).replace(',', '.') + "đ",
                    style = TextStyle(
                        textDecoration = TextDecoration.LineThrough,
                        fontFamily = sfProFamily,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier.padding(end = 4.dp, top = 1.5.dp),
                    color = MaterialTheme.colorScheme.neutralGrayscale60
                )
                Text(
                    text = String.format("%.3f", totalPayment).replace(',', '.') + "đ",
                    style = MaterialTheme.typography.h3SemiBoldStyle,
                    color = MaterialTheme.colorScheme.mainPrimary
                )
            }

            Divider(
                color = MaterialTheme.colorScheme.neutralGrayscale50,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Payment Method",
                    style = MaterialTheme.typography.h4BoldStyle,
                    modifier = Modifier.weight(1f)
                )
                YummyImage(
                    imgResId = R.drawable.ic_cash_method,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = "Cash",
                    style = MaterialTheme.typography.h5SemiBoldStyle,
                    color = MaterialTheme.colorScheme.neutralGrayscale90,
                    modifier = Modifier.padding(end = 21.dp)
                )
            }
            Divider(
                color = MaterialTheme.colorScheme.neutralGrayscale50,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            ) {
                orderInfoDetail.forEach {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = it.title,
                            style = MaterialTheme.typography.h5SemiBoldStyle,
                            color = MaterialTheme.colorScheme.neutralGrayscale90,
                            modifier = Modifier.padding(top = 12.dp, start = 24.dp)
                        )
                        Text(
                            text = it.detail,
                            style = MaterialTheme.typography.h5SemiBoldStyle,
                            color = MaterialTheme.colorScheme.neutralGrayscale90,
                            modifier = Modifier
                                .padding(top = 12.dp, end = 24.dp)
                                .width(201.dp)
                        )
                    }
                }
            }
            YummyButton(
                text = "Cancel order",
                modifier = Modifier
                    .fillMaxWidth()
                    .yummyPadding(
                        horizontal = 24.dp,
                        top = 24.dp,
                        bottom = 45.dp
                    ),
                isEnabled = false
            ) {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun OrderDetailScreenPreview() {
    MaterialTheme {
        Scaffold(
            topBar = {
                YummyToolbar(
                    title = {
                        Text(
                            text = "Order Detail", style = MaterialTheme.typography.h2BoldStyle
                                .copy(color = MaterialTheme.colorScheme.neutralGrayscale100)
                        )
                    },
                    leadingIcon = {
                        YummyIcon(
                            painterRes = R.drawable.ic_arrow_left_with_frame,
                            tint = MaterialTheme.colorScheme.neutralGrayscale90
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                OrderDetailScreen()
            }
        }
    }
}