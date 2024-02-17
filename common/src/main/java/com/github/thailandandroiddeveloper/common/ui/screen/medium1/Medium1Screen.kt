package com.github.thailandandroiddeveloper.common.ui.screen.medium1

import androidx.annotation.DrawableRes
import androidx.annotation.FloatRange
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.Error
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.Tertiary
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.TertiaryContainer
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.TertiaryFixedDim
import com.github.thailandandroiddeveloper.common.ui.theme.Typography

@Composable
private fun Medium1Screen(uiState: UiState) {
    // TODO
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(232.dp),
                color = TertiaryContainer
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(34.dp))
                    Text(
                        text = uiState.title,
                        style = Typography.headlineMedium,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = uiState.subtitle,
                        style = Typography.bodyLarge,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 3,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color.White,
                        modifier = Modifier
                            .width(241.dp)
                            .height(40.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.padding(end = 4.dp)
                        ) {
                            Text(
                                text = uiState.searchHint,
                                style = Typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp)
                            )
                            Surface(
                                color = Tertiary, shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.size(32.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_medium_1_search),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier.padding(4.dp)
                                )
                            }

                        }
                    }
                }

            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()

            ) {


            }
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(80.dp),
            color = TertiaryContainer
        ) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {

                BottomIcon(uiState.menus.get(0))
                BottomIcon(uiState.menus.get(1))
                BottomIcon(uiState.menus.get(2))
            }
        }
    }
}

@Composable
fun BottomIcon(menu: Menu) {
    Box(modifier = Modifier.width(126.33.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Surface(
                color = if (menu.selected) {
                    TertiaryFixedDim
                } else {
                    Color.Transparent
                },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .width(64.dp)
                    .height(32.dp)
            ) {
                Box() {

                    Icon(
                        painter = painterResource(id = menu.icon),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 20.dp)
                    )
                    if (menu.notificationCount != null) {
                        Surface(
                            color = Error,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .align(Alignment.TopEnd)
                                .size(16.dp),
                            shape = CircleShape,
                        ) {

                            Text(
                                text = menu.notificationCount.toString(),
                                color = Color.White,
                                style = Typography.labelSmall,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = menu.text, style = Typography.labelMedium)
        }
    }
}

@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
@Composable
fun Medium1ScreenPreview() = AppTheme {
    val uiState = UiState(
        title = "Hi, John Doe",
        subtitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vehicula erat pharetra enim dapibus, lacinia tristique felis aliquam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas suscipit et nibh nec laoreet. Sed imperdiet elit massa,",
        searchHint = "Explore more activities",
        searchIcon = R.drawable.ic_medium_1_search,
        activities = listOf(
            Activity(
                icon = R.drawable.ic_medium_1_activity_1,
                preview = R.drawable.img_medium_1_activity_1,
                title = "Praesent faucibus",
                content = "Morbi feugiat posuere felis, luctus fringilla mauris semper vel.",
                progress = null,

                detail = "Detail",
                action = "Done",
            ),
            Activity(
                icon = R.drawable.ic_medium_1_activity_2,
                preview = R.drawable.img_medium_1_activity_2,
                title = "Sollicitudin eu dui tincidunt vestibulum",
                content = "Sed feugiat nisi vitae pulvinar placerat. Nunc mi massa, gravida at eros nec, posuere viverra elit. Mauris ut lobortis arcu, vel malesuada dolor.",
                progress = Progress(
                    value = 0.5f,
                    text = "2 more to done",
                ),
                detail = "Detail",
                action = "Next",
            ),
            Activity(
                icon = R.drawable.ic_medium_1_activity_3,
                preview = R.drawable.img_medium_1_activity_3,
                title = "Morbi feugiat posuere felis",
                content = "Duis diam orci, elementum nec diam et, bibendum porta nulla. Quisque sed turpis congue, finibus ligula ac.",
                progress = null,
                detail = "Detail",
                action = "Done",
            ),
        ),
        menus = listOf(
            Menu(
                icon = R.drawable.ic_medium_1_explore,
                text = "Explore",
                selected = true,
                notificationCount = null,
            ),
            Menu(
                icon = R.drawable.ic_medium_1_highlight,
                text = "Highlight",
                selected = false,
                notificationCount = null,
            ),
            Menu(
                icon = R.drawable.ic_medium_1_notification,
                text = "Notification",
                selected = false,
                notificationCount = 3,
            ),
        ),
    )
    Medium1Screen(uiState = uiState)
}

private data class UiState(
    val title: String,
    val subtitle: String,
    val searchHint: String,
    @DrawableRes val searchIcon: Int,
    val activities: List<Activity>,
    val menus: List<com.github.thailandandroiddeveloper.common.ui.screen.medium1.Menu>,
)

private data class Activity(
    @DrawableRes val icon: Int,
    @DrawableRes val preview: Int,
    val title: String,
    val content: String,
    val progress: Progress?,
    val detail: String,
    val action: String,
)

private data class Progress(
    @FloatRange(from = 0.0, to = 1.0) val value: Float,
    val text: String,
)

data class Menu(
    @DrawableRes val icon: Int,
    val text: String,
    val selected: Boolean,
    val notificationCount: Int?,
)