/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.contracts.contextual.serialization

import org.jetbrains.kotlin.contracts.ContractDeserializerImpl
import org.jetbrains.kotlin.contracts.contextual.model.CleanerDeclaration
import org.jetbrains.kotlin.contracts.contextual.model.ProviderDeclaration
import org.jetbrains.kotlin.contracts.contextual.model.VerifierDeclaration
import org.jetbrains.kotlin.contracts.description.expressions.ContractDescriptionValue
import org.jetbrains.kotlin.metadata.extension.contracts.ContractsProtoBuf

interface SubpluginContractDeserializer {
    fun deserializeContextProvider(
        proto: ContractsProtoBuf.ContextProvider,
        worker: ContractDeserializerImpl.ContractDeserializationWorker,
        references: List<ContractDescriptionValue>
    ): ProviderDeclaration?

    fun deserializeContextVerifier(
        proto: ContractsProtoBuf.ContextVerifier,
        worker: ContractDeserializerImpl.ContractDeserializationWorker,
        references: List<ContractDescriptionValue>
    ): VerifierDeclaration?

    fun deserializeContextCleaner(
        proto: ContractsProtoBuf.ContextCleaner,
        worker: ContractDeserializerImpl.ContractDeserializationWorker,
        references: List<ContractDescriptionValue>
    ): CleanerDeclaration?
}