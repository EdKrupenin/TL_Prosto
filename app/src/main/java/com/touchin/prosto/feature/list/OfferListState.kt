package com.touchin.prosto.feature.list

import com.anadolstudio.core.viewmodel.lce.LceState
import com.touchin.prosto.feature.model.OfferUi

data class OfferListState(
    val loadingState: LceState = LceState.Loading,
    val offersList: List<OfferUi> = emptyList(),
)

