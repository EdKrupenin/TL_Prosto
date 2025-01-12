package com.touchin.prosto.feature.detail

import androidx.navigation.fragment.navArgs
import com.anadolstudio.core.viewbinding.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.touchin.prosto.R
import com.touchin.prosto.base.bottom.BaseContentBottom
import com.touchin.prosto.base.fragment.BaseContentFragment
import com.touchin.prosto.databinding.FragmentOfferDetailBinding
import com.touchin.prosto.di.viewmodel.assistedViewModel
import com.touchin.prosto.feature.model.OfferUi
import com.touchin.prosto.util.GradientDrawable

@Suppress("TooManyFunctions")
class OfferDetailFragment : BaseContentBottom<OfferDetailState, OfferDetailViewModel, OfferDetailController>(
    R.layout.fragment_offer_detail
) {

    private val binding by viewBinding { FragmentOfferDetailBinding.bind(it) }
    protected val args: OfferDetailFragmentArgs by navArgs()


    override fun createViewModelLazy() = assistedViewModel {
        getSharedComponent()
            .offerDetailViewModelFactory()
            .create(args.offer)
    }

    override fun render(state: OfferDetailState, controller: OfferDetailController) {
        binding.mainInfo.initView(state.offer)
        binding.offerName.text = args.offer.name
        binding.headerView.initView(args.offer, controller::onFavoriteChecked)

        binding.descriptionName.text = args.offer.longDescription
        binding.infoContainer.background = GradientDrawable(
            firstColor = args.offer.backgroundFirstColor,
            secondColor = args.offer.backgroundSecondColor,
        )
    }
}
