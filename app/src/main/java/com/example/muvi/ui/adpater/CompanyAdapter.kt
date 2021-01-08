package com.example.muvi.ui.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.muvi.base.BaseAdapter
import com.example.muvi.base.BaseViewHolder
import com.example.muvi.data.model.Company
import com.example.muvi.databinding.ItemCompanyBinding

class CompanyAdapter : BaseAdapter<Company, ItemCompanyBinding>({}, {}) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Company, ItemCompanyBinding> =
        CompanyHolder(
            ItemCompanyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    class CompanyHolder(
        private val itemCompanyBinding: ItemCompanyBinding
    ) : BaseViewHolder<Company, ItemCompanyBinding>(itemCompanyBinding, {}) {
        override fun onBind(itemData: Company) {
            super.onBind(itemData)
            itemCompanyBinding.company = itemData
        }
    }
}
